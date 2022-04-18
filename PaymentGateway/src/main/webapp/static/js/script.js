// add event handler realization
var addEvent = (function () {
  if (document.addEventListener) {
    return function (el, type, fn) {
      if (el && el.nodeName || el === window) {
        el.addEventListener(type, fn, false);
      } else if (el && el.length) {
        for (var i = 0; i < el.length; i++) {
          addEvent(el[i], type, fn);
        }
      }
    };
  } else {
    return function (el, type, fn) {
      if (el && el.nodeName || el === window) {
        el.attachEvent('on' + type, function () { return fn.call(el, window.event); });
      } else if (el && el.length) {
        for (var i = 0; i < el.length; i++) {
          addEvent(el[i], type, fn);
        }
      }
    };
  }
})();

// variables
var aLoops = []; // sound loops

// initialization
addEvent(window, 'load', function (event) {

    // load music files
    aLoops[0] = new Audio('media/background.ogg');
    aLoops[0].volume = 0.3;
    aLoops[1] = new Audio('media/button.ogg');
    aLoops[1].volume = 1.0;
    aLoops[2] = new Audio('media/button_click.ogg');
    aLoops[2].volume = 1.0;

    aLoops[0].addEventListener('ended', function() { // loop background sound
        this.currentTime = 0;
      //s    this.play();
    }, false);
   //s   aLoops[0].play();
});

//s   all the buttons
var aBtns = document.querySelectorAll('#nav li');

//s   onmouseover event handler
addEvent(aBtns, 'mouseover', function (event) {
   //s   aLoops[1].currentTime = 0;
   //s   aLoops[1].play(); // play click sound
});

//s   onmouseout event handler
addEvent(aBtns, 'mouseout', function (event) {
  //s  aLoops[1].currentTime = 0;
  //s  aLoops[1].pause(); // play click sound
});

// onclick event handler
addEvent(aBtns, 'click', function (event) {
   //s   aLoops[2].currentTime = 0;
    //s   aLoops[2].play(); // play click sound
});