// JavaScript Document
/*!
 * Lightbox v2.7.4
 * by Lokesh Dhakar
 *
 * More info:
 * http://lokeshdhakar.com/projects/lightbox2/
 *
 * Copyright 2007, 2015 Lokesh Dhakar
 * Released under the MIT license
 * https://github.com/lokesh/lightbox2/blob/master/LICENSE
 */(function(){var c=jQuery,n=function(){function c(){this.alwaysShowNavOnTouchDevices=!1;this.fadeDuration=500;this.fitImagesInViewport=!0;this.positionFromTop=50;this.resizeDuration=700;this.showImageNumberLabel=!0;this.wrapAround=!1}return c.prototype.albumLabel=function(a,b){return"Image "+a+" of "+b},c}(),p=function(){function d(a){this.options=a;this.album=[];this.currentImageIndex=void 0;this.init()}return d.prototype.init=function(){this.enable();this.build()},d.prototype.enable=function(){var a=this;c("body").on("click","a[rel^\x3dlightbox], area[rel^\x3dlightbox], a[data-lightbox], area[data-lightbox]",function(b){return a.start(c(b.currentTarget)),!1})},d.prototype.build=function(){var a=this;c('\x3cdiv id\x3d"lightboxOverlay" class\x3d"lightboxOverlay"\x3e\x3c/div\x3e\x3cdiv id\x3d"lightbox" class\x3d"lightbox"\x3e\x3cdiv class\x3d"lb-outerContainer"\x3e\x3cdiv class\x3d"lb-container"\x3e\x3cimg class\x3d"lb-image" src\x3d"data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw\x3d\x3d" /\x3e\x3cdiv class\x3d"lb-nav"\x3e\x3ca class\x3d"lb-prev" href\x3d"" \x3e\x3c/a\x3e\x3ca class\x3d"lb-next" href\x3d"" \x3e\x3c/a\x3e\x3c/div\x3e\x3cdiv class\x3d"lb-loader"\x3e\x3ca class\x3d"lb-cancel"\x3e\x3c/a\x3e\x3c/div\x3e\x3c/div\x3e\x3c/div\x3e\x3cdiv class\x3d"lb-dataContainer"\x3e\x3cdiv class\x3d"lb-data"\x3e\x3cdiv class\x3d"lb-details"\x3e\x3cspan class\x3d"lb-caption"\x3e\x3c/span\x3e\x3cspan class\x3d"lb-number"\x3e\x3c/span\x3e\x3c/div\x3e\x3cdiv class\x3d"lb-closeContainer"\x3e\x3ca class\x3d"lb-close"\x3e\x3c/a\x3e\x3c/div\x3e\x3c/div\x3e\x3c/div\x3e\x3c/div\x3e').appendTo(c("body"));this.$lightbox=c("#lightbox");this.$overlay=c("#lightboxOverlay");this.$outerContainer=this.$lightbox.find(".lb-outerContainer");this.$container=this.$lightbox.find(".lb-container");this.containerTopPadding=parseInt(this.$container.css("padding-top"),10);this.containerRightPadding=parseInt(this.$container.css("padding-right"),10);this.containerBottomPadding=parseInt(this.$container.css("padding-bottom"),10);this.containerLeftPadding=parseInt(this.$container.css("padding-left"),10);this.$overlay.hide().on("click",function(){return a.end(),!1});this.$lightbox.hide().on("click",function(b){return"lightbox"===c(b.target).attr("id")&&a.end(),!1});this.$outerContainer.on("click",function(b){return"lightbox"===c(b.target).attr("id")&&a.end(),!1});this.$lightbox.find(".lb-prev").on("click",function(){var b=parseInt($(".lb-number").html().split("of")[0].replace("Image",""))-2;$("#resume_box_d\x3eli").removeClass("current").eq(b).addClass("current");b=$("#resume_box_d\x3eli.current\x3einput").val();$('input[name\x3d"temp_val"]').val(b);return 0===a.currentImageIndex?a.changeImage(a.album.length-1):a.changeImage(a.currentImageIndex-1),!1});this.$lightbox.find(".lb-next").on("click",function(){var b=parseInt($(".lb-number").html().split("of")[0].replace("Image",""));$("#resume_box_d\x3eli").removeClass("current").eq(b).addClass("current");b=$("#resume_box_d\x3eli.current\x3einput").val();$('input[name\x3d"temp_val"]').val(b);return a.currentImageIndex===a.album.length-1?a.changeImage(0):a.changeImage(a.currentImageIndex+1),!1});this.$lightbox.find(".lb-loader, .lb-close").on("click",function(){return a.end(),!1})},d.prototype.start=function(a){function b(a){d.album.push({link:a.attr("href"),title:a.attr("data-title")||a.attr("title")})}var d=this,f=c(window);f.on("resize",c.proxy(this.sizeOverlay,this));c("select, object, embed").css({visibility:"hidden"});this.sizeOverlay();this.album=[];var g,k=0;if(g=a.attr("data-lightbox")){g=c(a.prop("tagName")+'[data-lightbox\x3d"'+g+'"]');for(var e=0;e<g.length;e=++e)b(c(g[e])),g[e]===a[0]&&(k=e)}else if("lightbox"===a.attr("rel"))b(a);else for(g=c(a.prop("tagName")+'[rel\x3d"'+a.attr("rel")+'"]'),e=0;e<g.length;e=++e)b(c(g[e])),g[e]===a[0]&&(k=e);a=f.scrollTop()+this.options.positionFromTop;f=f.scrollLeft();this.$lightbox.css({top:a+"px",left:f+"px"}).fadeIn(this.options.fadeDuration);this.changeImage(k)},d.prototype.changeImage=function(a){var b=this;this.disableKeyboardNav();var d=this.$lightbox.find(".lb-image");this.$overlay.fadeIn(this.options.fadeDuration);c(".lb-loader").fadeIn("slow");this.$lightbox.find(".lb-image, .lb-nav, .lb-prev, .lb-next, .lb-dataContainer, .lb-numbers, .lb-caption").hide();this.$outerContainer.addClass("animating");var f=new Image;f.onload=function(){var g,k,e,h,l,m;d.attr("src",b.album[a].link);c(f);d.width(f.width);d.height(f.height);b.options.fitImagesInViewport&&(m=c(window).width(),l=c(window).height(),h=m-b.containerLeftPadding-b.containerRightPadding-20,e=l-b.containerTopPadding-b.containerBottomPadding-120,b.options.maxWidth&&b.options.maxWidth<h&&(h=b.options.maxWidth),b.options.maxHeight&&b.options.maxHeight<h&&(e=b.options.maxHeight),(f.width>h||f.height>e)&&(f.width/h>f.height/e?(k=h,g=parseInt(f.height/(f.width/k),10),d.width(k),d.height(g)):(g=e,k=parseInt(f.width/(f.height/g),10),d.width(k),d.height(g))));b.sizeContainer(d.width(),d.height())};f.src=this.album[a].link;this.currentImageIndex=a},d.prototype.sizeOverlay=function(){this.$overlay.width(c(window).width()).height(c(document).height())},d.prototype.sizeContainer=function(a,b){function c(){d.$lightbox.find(".lb-dataContainer").width(e);d.$lightbox.find(".lb-prevLink").height(h);d.$lightbox.find(".lb-nextLink").height(h);d.showImage()}var d=this,g=this.$outerContainer.outerWidth(),k=this.$outerContainer.outerHeight(),e=a+this.containerLeftPadding+this.containerRightPadding,h=b+this.containerTopPadding+this.containerBottomPadding;g!==e||k!==h?this.$outerContainer.animate({width:e,height:h},this.options.resizeDuration,"swing",function(){c()}):c()},d.prototype.showImage=function(){this.$lightbox.find(".lb-loader").stop(!0).hide();this.$lightbox.find(".lb-image").fadeIn("slow");this.updateNav();this.updateDetails();this.preloadNeighboringImages();this.enableKeyboardNav()},d.prototype.updateNav=function(){var a=!1;try{document.createEvent("TouchEvent"),a=this.options.alwaysShowNavOnTouchDevices?!0:!1}catch(b){}this.$lightbox.find(".lb-nav").show();1<this.album.length&&(this.options.wrapAround?(a&&this.$lightbox.find(".lb-prev, .lb-next").css("opacity","1"),this.$lightbox.find(".lb-prev, .lb-next").show()):(0<this.currentImageIndex&&(this.$lightbox.find(".lb-prev").show(),a&&this.$lightbox.find(".lb-prev").css("opacity","1")),this.currentImageIndex<this.album.length-1&&(this.$lightbox.find(".lb-next").show(),a&&this.$lightbox.find(".lb-next").css("opacity","1"))))},d.prototype.updateDetails=function(){var a=this;if("undefined"!=typeof this.album[this.currentImageIndex].title&&""!==this.album[this.currentImageIndex].title&&this.$lightbox.find(".lb-caption").html(this.album[this.currentImageIndex].title).fadeIn("fast").find("a").on("click",function(a){void 0!==c(this).attr("target")?window.open(c(this).attr("href"),c(this).attr("target")):location.href=c(this).attr("href")}),1<this.album.length&&this.options.showImageNumberLabel){var b=this.options.albumLabel(this.currentImageIndex+1,this.album.length);this.$lightbox.find(".lb-number").text(b).fadeIn("fast")}else this.$lightbox.find(".lb-number").hide();this.$outerContainer.removeClass("animating");this.$lightbox.find(".lb-dataContainer").fadeIn(this.options.resizeDuration,function(){return a.sizeOverlay()})},d.prototype.preloadNeighboringImages=function(){this.album.length>this.currentImageIndex+1&&((new Image).src=this.album[this.currentImageIndex+1].link);0<this.currentImageIndex&&((new Image).src=this.album[this.currentImageIndex-1].link)},d.prototype.enableKeyboardNav=function(){c(document).on("keyup.keyboard",c.proxy(this.keyboardAction,this))},d.prototype.disableKeyboardNav=function(){c(document).off(".keyboard")},d.prototype.keyboardAction=function(a){a=a.keyCode;var b=String.fromCharCode(a).toLowerCase();27===a||b.match(/x|o|c/)?this.end():"p"===b||37===a?0!==this.currentImageIndex?this.changeImage(this.currentImageIndex-1):this.options.wrapAround&&1<this.album.length&&this.changeImage(this.album.length-1):("n"===b||39===a)&&(this.currentImageIndex!==this.album.length-1?this.changeImage(this.currentImageIndex+1):this.options.wrapAround&&1<this.album.length&&this.changeImage(0))},d.prototype.end=function(){this.disableKeyboardNav();c(window).off("resize",this.sizeOverlay);this.$lightbox.fadeOut(this.options.fadeDuration);this.$overlay.fadeOut(this.options.fadeDuration);c("select, object, embed").css({visibility:"visible"})},d}();c(function(){var c=new n;new p(c)})}).call(this);