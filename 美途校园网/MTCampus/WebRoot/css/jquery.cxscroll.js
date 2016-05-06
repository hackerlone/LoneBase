/*!
 * jQuery cxScroll 1.2.1
 * http://code.ciaoca.com/
 * https://github.com/ciaoca/cxScroll
 * E-mail: ciaoca@gmail.com
 * Released under the MIT license
 * Date: 2014-03-10
 */
(function($){
	$.fn.cxScroll=function(settings){
		if(!this.length){return};
		settings=$.extend({},$.cxScroll.defaults,settings);

		var obj=this;
		var scroller={
			lock:false,
			dom:{}
		};

		scroller.init=function(){
			scroller.dom.box=obj.find(".box");
			scroller.dom.list=scroller.dom.box.find(".list");
			scroller.dom.items=scroller.dom.list.find("li");
			scroller.itemSum=scroller.dom.items.length;

			// 娌℃湁鍏冪礌鎴栧彧鏈�1涓厓绱犳椂锛屼笉杩涜婊氬姩
			if(scroller.itemSum<=1){return};

			scroller.dom.prevBtn=obj.find(".prev");
			scroller.dom.nextBtn=obj.find(".next");
			scroller.itemWidth=scroller.dom.items.outerWidth(true);
			scroller.itemHeight=scroller.dom.items.outerHeight(true);

			if(settings.direction=="left"||settings.direction=="right"){
				// 瀹瑰櫒瀹藉害涓嶈冻鏃讹紝涓嶈繘琛屾粴鍔�
				if(scroller.itemWidth*scroller.itemSum<=scroller.dom.box.outerWidth()){return};

				scroller.prevVal="left";
				scroller.nextVal="right";
				scroller.moveVal=scroller.itemWidth;
			}else{
				// 瀹瑰櫒楂樺害涓嶈冻鏃讹紝涓嶈繘琛屾粴鍔�
				if(scroller.itemHeight*scroller.itemSum<=scroller.dom.box.outerHeight()){return};

				scroller.prevVal="top";
				scroller.nextVal="bottom";
				scroller.moveVal=scroller.itemHeight;
			};

			// 鍏冪礌锛氬悗琛�
			scroller.dom.list.append(scroller.dom.list.html());

			// 娣诲姞鍏冪礌锛氭墜鍔ㄦ搷浣滄寜閽�
			if(settings.prevBtn&&!scroller.dom.prevBtn.length){
				scroller.dom.prevBtn=$("<a></a>",{"class":"prev"}).prependTo(obj);
			};
			if(settings.nextBtn&&!scroller.dom.nextBtn.length){
				scroller.dom.nextBtn=$("<a></a>",{"class":"next"}).prependTo(obj);
			};

			// 浜嬩欢锛氶紶鏍囩Щ鍏ュ仠姝紝绉诲嚭寮€濮�
			if(settings.auto){
				obj.hover(function(){
					settings.auto=false;
					scroller.lock=false;
					scroller.off();
				},function(){
					settings.auto=true;
					scroller.lock=false;
					scroller.on();
				});
			};

			scroller.bindEvents();
			scroller.on();
		};
		
		scroller.bindEvents=function(){
			if(settings.nextBtn&&scroller.dom.prevBtn.length){
				scroller.dom.nextBtn.bind("click",function(){
					if(!scroller.lock){
						scroller.goto(scroller.nextVal,settings.accel);
					};
				});
			};
			if(settings.prevBtn&&scroller.dom.prevBtn.length){
				scroller.dom.prevBtn.bind("click",function(){
					if(!scroller.lock){
						scroller.goto(scroller.prevVal,settings.accel);
					};
				});
			};
		};

		// 鏂规硶锛氬紑濮�
		scroller.on=function(){
			if(!settings.auto){return};
			if(typeof(scroller.run)!=="undefined"){
				clearTimeout(scroller.run);
			};

			scroller.run=setTimeout(function(){
				scroller.goto(settings.direction);
			},settings.time);
		};

		// 鏂规硶锛氬仠姝�
		scroller.off=function(){
			scroller.dom.box.stop(true);
			if(typeof(scroller.run)!=="undefined"){
				clearTimeout(scroller.run);
			};
		};

		// 鏂规硶锛氭粴鍔�
		scroller.goto=function(d,t){
			scroller.off();
			if(settings.controlLock){
				scroller.lock=true;
			};

			var _max;	// _max	婊氬姩鐨勬渶澶ч檺搴�
			var _dis;	// _dis	婊氬姩鐨勮窛绂�
			var _speed=t||settings.speed;

			switch(d){
				case "left":
				case "top":
					_max=0;
					if(d=="left"){
						if(parseInt(scroller.dom.box.scrollLeft(),10)==0){
							scroller.dom.box.scrollLeft(scroller.itemSum*scroller.moveVal);
						};
						_dis=scroller.dom.box.scrollLeft()-(scroller.moveVal*settings.step);
						if(_dis%scroller.itemWidth>0){
							_dis-=(_dis%scroller.itemWidth)-scroller.itemWidth;
						};
						if(_dis<_max){_dis=_max};
						scroller.dom.box.animate({"scrollLeft":_dis},_speed,settings.easing,function(){
							if(parseInt(scroller.dom.box.scrollLeft(),10)<=_max){
								scroller.dom.box.scrollLeft(0);
							};
						});
					}else{
						if(parseInt(scroller.dom.box.scrollTop(),10)==0){
							scroller.dom.box.scrollTop(scroller.itemSum*scroller.moveVal);
						};
						_dis=scroller.dom.box.scrollTop()-(scroller.moveVal*settings.step);
						if(_dis%scroller.itemHeight>0){
							_dis-=(_dis%scroller.itemHeight)-scroller.itemHeight;
						};
						if(_dis<_max){_dis=_max};
						scroller.dom.box.animate({"scrollTop":_dis},_speed,settings.easing,function(){
							if(parseInt(scroller.dom.box.scrollTop(),10)<=_max){
								scroller.dom.box.scrollTop(0);
							};
						});
					};
					break;
	
				case "right":
				case "bottom":
					_max=scroller.itemSum*scroller.moveVal;
					if(d=="right"){
						_dis=scroller.dom.box.scrollLeft()+(scroller.moveVal*settings.step);
						if(_dis%scroller.itemWidth>0){
							_dis-=(_dis%scroller.itemWidth);
						};
						if(_dis>_max){_dis=_max};
						scroller.dom.box.animate({"scrollLeft":_dis},_speed,settings.easing,function(){
							if(parseInt(scroller.dom.box.scrollLeft(),10)>=_max){
								scroller.dom.box.scrollLeft(0);
							};
						});
					}else{
						_dis=scroller.dom.box.scrollTop()+(scroller.moveVal*settings.step);
						if(_dis%scroller.itemHeight>0){
							_dis-=(_dis%scroller.itemHeight);
						};
						if(_dis>_max){_dis=_max};
						scroller.dom.box.animate({"scrollTop":_dis},_speed,settings.easing,function(){
							if(parseInt(scroller.dom.box.scrollTop(),10)>=_max){
								scroller.dom.box.scrollTop(0);
							};
						});
					};
					break;
				
				// not default
			};
			
			scroller.dom.box.queue(function(){
				if(settings.controlLock){
					scroller.lock=false;
				};
				scroller.on();
				$(this).dequeue();
			});
		};

		scroller.init();
	};

	// 榛樿鍊�
	$.cxScroll={defaults:{
		direction:"right",	// 婊氬姩鏂瑰悜
		easing:"swing",		// 缂撳姩鏂瑰紡
		step:2,				// 婊氬姩姝ラ暱
		accel:160,			// 鎵嬪姩婊氬姩閫熷害
		speed:800,			// 鑷姩婊氬姩閫熷害
		time:4000,			// 鑷姩婊氬姩闂撮殧鏃堕棿
		auto:true,			// 鏄惁鑷姩婊氬姩
		prevBtn:true,		// 鏄惁浣跨敤 prev 鎸夐挳
		nextBtn:true,		// 鏄惁浣跨敤 next 鎸夐挳
		safeLock:true		// 婊氬姩鏃舵槸鍚﹂攣瀹氭帶鍒舵寜閽�
	}};
})(jQuery);