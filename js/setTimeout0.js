

function f() {
    console.log('inner function of setTimeout ')    
}
console.log('>>>> start execution ')

setTimeout(f, 0);

Promise.resolve(setTimeout(f, 6000)).then(() => {console.log('promise resolve')})

new Promise((resolve, reject) => {
    
})

console.log('<<<< end execution ')
