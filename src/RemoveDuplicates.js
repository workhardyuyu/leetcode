//use indexOf
function unique (arr) {
  var result = []; 
  for (var i = 0; i < arr.length; i++)
  {
    if (result.indexOf(arr[i]) == -1) result.push(arr[i]);
  }
  return result;
}

//use hash,but this method has bug: var a = [1, 2, 3, 4, '3', 5], return [1, 2, 3, 4, 5]
function unique (arr)
{
    var hash = {},result = []; 
    for(var i = 0; i < arr.length; i++)
    {
        if (!hash[arr[i]]) 
        {
            hash[arr[i]] = true; 
            result.push(arr[i]); 
        }
    }
    return result;
}

//use sort, but this method has bug: var a = [1, 2, 3, 4, '3', 5], return [1, 2, 3, 4, 5]
function unique (arr) {
    arr.sort();
    var result=[arr[0]];
    for(var i = 1; i < arr.length; i++){
        if( arr[i] !== arr[i-1]) {
            result.push(arr[i]);
        }
    }
    return result;
}

//use sort. No bug. (=== will not cause bug, == and !== will)
function unique (arr) {
    arr.sort();
    var result=[arr[0]];
    for(var i = 1; i < arr.length; i++){
        if( arr[i] === arr[i-1]) {
            continue;
        }
        result.push(arr[i]);
    }
    return result;
}

//worst solution, with no bug
function unique (arr) {
    if(arr.length == 0) return;
    var result = [arr[0]], isRepeate;
    for( var i = 0, j = arr.length; i < j; i++ ){
        isRepeate = false;
        for( var k = 0, h = result.length; k < h; k++){
            if(result[k] === arr[i]){
                isRepeate = true;
                break;
            }
            if(k == h) break;
        }
        if( !isRepeate ) result.push(arr[i]);
    }
    return result;
}