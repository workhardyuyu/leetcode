//1. Intersection
function array1.filter(function(n) {
    return array2.indexOf(n) != -1
});

//2. Union
function arrayUnique(array) {
    var a = array.concat();
    for(var i=0; i<a.length; ++i) {
        for(var j=i+1; j<a.length; ++j) {
            if(a[i] === a[j])
                a.splice(j--, 1);
        }
    }
 
    return a;
};


//3. difference
Array.prototype.diff = function(a) {
    return this.filter(function(i) {return a.indexOf(i) &lt; 0;});
};