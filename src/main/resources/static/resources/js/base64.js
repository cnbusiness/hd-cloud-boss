~function(r,t){"function"==typeof define&&define.amd?define([],t):"object"==typeof module&&module.exports?module.exports=t():r.Base=t()}(this,function(){"use strict";function r(){this._keyStr="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/="}return r.prototype.encode=function(r){var t,e,o,n,h,i,a,d="",f=0;for(r=this._utf8_encode(r);f<r.length;)t=r.charCodeAt(f++),e=r.charCodeAt(f++),o=r.charCodeAt(f++),n=t>>2,h=(3&t)<<4|e>>4,i=(15&e)<<2|o>>6,a=63&o,isNaN(e)?i=a=64:isNaN(o)&&(a=64),d=d+this._keyStr.charAt(n)+this._keyStr.charAt(h)+this._keyStr.charAt(i)+this._keyStr.charAt(a);return d},r.prototype.decode=function(r){var t,e,o,n,h,i,a,d="",f=0;for(r=r.replace(/[^A-Za-z0-9\+\/\=]/g,"");f<r.length;)n=this._keyStr.indexOf(r.charAt(f++)),h=this._keyStr.indexOf(r.charAt(f++)),i=this._keyStr.indexOf(r.charAt(f++)),a=this._keyStr.indexOf(r.charAt(f++)),t=n<<2|h>>4,e=(15&h)<<4|i>>2,o=(3&i)<<6|a,d+=String.fromCharCode(t),64!=i&&(d+=String.fromCharCode(e)),64!=a&&(d+=String.fromCharCode(o));return d=this._utf8_decode(d)},r.prototype._utf8_encode=function(r){r=r.replace(/\r\n/g,"\n");for(var t="",e=0;e<r.length;e++){var o=r.charCodeAt(e);o<128?t+=String.fromCharCode(o):o>127&&o<2048?(t+=String.fromCharCode(o>>6|192),t+=String.fromCharCode(63&o|128)):(t+=String.fromCharCode(o>>12|224),t+=String.fromCharCode(o>>6&63|128),t+=String.fromCharCode(63&o|128))}return t},r.prototype._utf8_decode=function(r){for(var t="",e=0,o=0,n=0,h=0;e<r.length;)o=r.charCodeAt(e),o<128?(t+=String.fromCharCode(o),e++):o>191&&o<224?(n=r.charCodeAt(e+1),t+=String.fromCharCode((31&o)<<6|63&n),e+=2):(n=r.charCodeAt(e+1),h=r.charCodeAt(e+2),t+=String.fromCharCode((15&o)<<12|(63&n)<<6|63&h),e+=3);return t},new r});