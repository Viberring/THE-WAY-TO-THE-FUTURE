function setDimension(name, value) {
    if (name === 'height') {
        this._height = value;
        return;
    }
    if (name === 'width') {
        this._width = value;
        return;
    }
}


function setHeight(value) { this._height = value; }
function setWidth(value) { this._width = value; }

function bookConcert(aCustomer, isPremium) {
    if (isPremium) {
        // logic for premium booking 
    } else {
        // logic for regular booking 
    }
}
//////////////


aShipment.deliveryDate = deliveryDate(anOrder, true);
aShipment.deliveryDate = deliveryDate(anOrder, false);
function deliveryDate(anOrder, isRush) {
    if (isRush) {
        let deliveryTime;
        if (["MA", "CT"].includes(anOrder.deliveryState)) deliveryTime = 1; 
        else if (["NY", "NH"].includes(anOrder.deliveryState)) deliveryTime = 2; 
        else deliveryTime = 3;
        return anOrder.placedOn.plusDays(1 + deliveryTime);
    }
    else {
        let deliveryTime;
        if (["MA", "CT", "NY"].includes(anOrder.deliveryState)) deliveryTime = 2; 
        else if (["ME", "NH"].includes(anOrder.deliveryState)) deliveryTime = 3; 
        else deliveryTime = 4;
        return anOrder.placedOn.plusDays(2 + deliveryTime);
    }
}

function deliveryDate(anOrder, isRush) {
    if (isRush) return rushDeliveryDate(anOrder); 
    else return regularDeliveryDate(anOrder);
}

function rushDeliveryDate(anOrder) {
    let deliveryTime;
    if (["MA", "CT"] .includes(anOrder.deliveryState)) deliveryTime = 1;
    else if (["NY", "NH"].includes(anOrder.deliveryState)) deliveryTime = 2;
    else deliveryTime = 3;
    return anOrder.placedOn.plusDays(1 + deliveryTime);
}
function regularDeliveryDate(anOrder) {
    let deliveryTime;
    if (["MA", "CT", "NY"].includes(anOrder.deliveryState)) deliveryTime = 2; 
    else if (["ME", "NH"] .includes(anOrder.deliveryState)) deliveryTime = 3;
    else deliveryTime = 4;
    return anOrder.placedOn.plusDays(2 + deliveryTime);
}
///////
function deliveryDate(anOrder, isRush) {
    let result;
    let deliveryTime;
    if (anOrder.deliveryState === "MA" || anOrder.deliveryState === "CT")
        deliveryTime = isRush? 1 : 2;
    else if (anOrder.deliveryState === "NY" || anOrder.deliveryState === "NH") {
        deliveryTime = 2;
    if (anOrder.deliveryState === "NH" && !isRush)
        deliveryTime = 3; }
    else if (isRush) deliveryTime = 3;
    else if (anOrder.deliveryState === "ME") deliveryTime = 3;
    else
        deliveryTime = 4;
    result = anOrder.placedOn.plusDays(2 + deliveryTime); 
    if (isRush) result = result.minusDays(1);
    return result;
}
function rushDeliveryDate (anOrder) {return deliveryDate(anOrder, true);}
function regularDeliveryDate(anOrder) {return deliveryDate(anOrder, false);}