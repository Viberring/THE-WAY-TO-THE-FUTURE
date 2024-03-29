function statement(invoice) {
    let totalAmount = 0;
    let result = `Statement for ${invoice.customer}\n`;
    for(let perf of invoice.performances) {
        // print line for this order
        result += `    ${playFor(perf).name}: ${usd(amountFor(perf))} (${perf.audience} searts)\n`
        totalAmount += amountFor(perf);
    }
    result += `Amount owed is ${usd(totalAmount)}\n`;
    result += `You earned ${totalVolumeCredits(invoice)} credits\n`;
    return result;
}

function amountFor(aPerformance) {
    let result = 0;
    switch (playFor(aPerformance).type) {
        case "tragedy":
            result = 40000;
            if (aPerformance.audience > 30) {
                result += 1000 * (aPerformance.audience - 30);
            }
            break;
        case "comedy":
            result = 30000;
            if (aPerformance.audience > 20) {
                result += 10000 + 500 * (aPerformance.audience - 20);
            }    
            result += 300 * aPerformance.audience;
            break;
        default:
            throw new Error(`unknown type: ${play.type}`);
    }
    return result;
}

function playFor(aPerformance) {
    return plays[aPerformance.playID];
}
function volumeCreditsFor(aPerformance) {
    let result = 0;
    result += Math.max(aPerformance.audience - 30, 0);
    if ("comedy" === playFor(aPerformance).type) result += Math.floor(aPerformance.audience / 5);
    return result;
}
function usd(aNumber) {
    return new Intl.NumberFormat("en-US", {style: "currency", currency: "USD", minimumFractionDigits: 2}).format(aNumber/100);
}

function totalVolumeCredits(invoice) {
    let volumeCredits = 0;
    for (let perf of invoice.performances) {
        volumeCredits += volumeCreditsFor(perf);
    }
    return volumeCredits;
}

import fs from 'fs';
let invoices, plays;
invoices = JSON.parse(fs.readFileSync('./invoices.json', 'utf8'))
plays = JSON.parse(fs.readFileSync('./plays.json', 'utf8'))

console.log(statement(invoices[0], plays));