function merge(arr, arrcopy, lo, mid, hi) {

}

function UpToDownSort(arr) {
  let arrcopy = new Array()
  let length = arr.length

  function iter(arr, arrcopy, lo, hi) {
    if(lo >= hi) return
    else {
      let mid = lo + (hi - lo) / 2
      iter(arr, arrcopy, lo, mid)
      iter(arr, arrcopy, mid, hi)
      merge(arr, arrcopy, lo, mid, hi)
    }
  }

  function iter() {

  }

  iter(arr, arrcopy, 0, length)
}

function DownToUpSort(arr) {
    let arrcopy = new Array(),
        len = arr.length

    for(let i = 0; i < len; i++) {

    }
}
