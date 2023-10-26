var isEmpty = function(obj) {
    obj = JSON.stringify(obj);
    return obj.length == 2;
};