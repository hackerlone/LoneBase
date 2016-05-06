// JavaScript Document
/**
 * Created by dcg on 15/9/28.
 */
var
    $changeBox = $(".change_res"),
    $shade = $(".shade"),
    changeDay = $(".change_day_12"),
    resume_flag = $(".aside_inf_flg"),
    $body = $("body"),
    $gdata = $("#gdata"),
    ruuid = $gdata.attr("data-ruuid");

//鏈熸湜瀹炰範閫夋嫨澶╂暟
$(".change_day_6>span").on("click", function () {
    $(this)
        .addClass("active").siblings().removeClass("active")
        .parent().prev().val($(this).data("day"));
});
//鏈熸湜瀹炰範閫夋嫨鏈堟暟
changeDay.on("click", "span", function () {
    var
        $this = $(this),
        isOk = true,
        all = 0;
    changeDay.find(".active").each(function () {
        all++;
    });
    if (($this.next().is(".active") || $this.prev().is(".active")) && !($this.next().is(".active") && $this.prev().is(".active"))) {

    } else {
        isOk = false;
    }
    if ($this.data("mon") == 12) {
        if ($this.prev().is(".active") && $this.parent().children().first().is(".active")) {
            isOk = false;
        } else if ($this.prev().is(".active") || $this.parent().children().first().is(".active")) {
            isOk = true;
        }
    } else if ($this.data("mon") == "01") {
        if ($this.next().is(".active") && $this.parent().children().last().is(".active")) {

            isOk = false;
        } else if ($this.next().is(".active") || $this.parent().children().last().is(".active")) {
            isOk = true;
        }
    } else if (!$this.next().is(".active") && !$this.prev().is(".active") && $this.is(".active")) {
        isOk = true;
    } else if ($this.is(".now_y")) {
        if ((!$this.next().is(".now_y") && $this.next().is(".active")) || ((!$this.prev().is(".now_y") && $this.prev().is(".active")))) {
            isOk = false;
        }
    } else if (!$this.is(".now_y")) {
        if (($this.next().is(".now_y") && $this.next().is(".active")) || (($this.prev().is(".now_y") && $this.prev().is(".active")))) {
            isOk = false;
        }
    }
    if((all == 11 && !$this.is(".active")) || all < 1){
        isOk = true;
    }else if(all == 1 && $this.is(".active")){
        isOk = true;
    }
    if(all == 12){
        if($this.data("mon") == 10 || $this.data("mon") == 11){
            isOk = true;
        }
    }
    if (isOk) {
        $this.toggleClass("active");
    } else {
        alert("鍙兘閫夋嫨杩炵画鐨勬湀浠�")
    }
});

if (typeof Array.prototype.forEach != "function") {
    Array.prototype.forEach = function (fn, context) {
        for (var k = 0, length = this.length; k < length; k++) {
            if (typeof fn === "function" && Object.prototype.hasOwnProperty.call(this, k)) {
                fn.call(context, this[k], k, this);
            }
        }
    };
}
//寮瑰嚭淇敼椤甸潰
var $infBox = $(".section_item"), name, popName;
$infBox.on("click", function () {
    if (!$gdata.attr("data-ruuid") && !$(this).is(".item_expect") ){
        alert("璇峰厛瀹屽杽鏈熸湜瀹炰範");
        return;
    }
    changeMsg($(this));
});
function changeMsg($this, flg) {
    var $model = $this.children().first();
    name = $model.attr("class");
    popName = name + "_change";
    $(".change_close_item").click();
    var
        $changeItem = $changeBox.find("." + popName),
        $expcDay = $changeItem.find(".expect_days"),
        itemLength = parseInt($model.find(".item_all").val());
    if (!flg) {
        $changeBox.fadeIn(500);
        $shade.fadeIn(500);
        $changeItem.fadeIn(500);
        $body.css({
            "overflow": "hidden"
        });
        $(".box").css({
            "position": "relative",
            "left": "-7px"
        });
    }
    if (!$this.is(".complete")) {
        return;
    }
    //---------澶氫釜椤圭洰
    if (itemLength > 1) {
        var
            addItem = $changeItem.find(".add_item"),
            close = "<span class=\"change_close_item\"></span>";
        for (var i = 1; i < itemLength; i++) {
            addItem.prev().append(addItem.prev().find(".change_section").eq(0).clone().prepend(close));
        }
    }
    //-----------------璧嬪€�
    $changeItem.find(".change_section").each(function (i) {
        $(this).find(".v_itm").each(function () {
            var $this = $(this);
            if ($this.is(".special")) {
                if ($this.is(".skill_lev")) {
                    var level = $model.find(".sk1.item" + i).val();
                    $this
                        .val(level)
                        .next().children().each(function () {
                            if ($(this).data("lev") == level) {
                                $(this).click();
                            }
                        });
                } else if ($this.is(".days")) {
                    $expcDay.children().each(function () {
                        if (('' + $(this).data("day")) === $model.find(".d1").text()) {
                            $(this).addClass("active").siblings().removeClass("active");
                        }
                    });
                } else if ($this.is(".mon") && $model.find(".months").val()) {
                    var $mon = $this.next().children();
                    $mon
                        .removeClass("active")
                        .each(function () {
                            var $monV = $(this);
                            var monArr = $model.find(".months").val().replace(/[ | '' | "["]/g, '').replace("]", '').split(",");
                            monArr.forEach(function (item) {
                                if (item == '' + $monV.data("mon")) {
                                    $monV.addClass("active");
                                }
                            });
                        });
                    if (!$mon.is(".active")) {
                        var
                            nowM = new Date(),
                            mons = parseInt($(".mons").text()) - 1,
                            nowMonth = nowM.getMonth(),
                            endMonth,
                            monthAll = $(".change_day_12").children(),
                            $beginM = monthAll.eq(nowMonth);
                        endMonth = nowMonth + mons;
                        if (endMonth >= 11) {
                            endMonth -= 11;
                            $beginM.nextAll().addClass("active");
                            monthAll.eq(endMonth).prevAll().addClass("active");
                        } else {
                            $beginM.nextAll().addClass("active");
                            monthAll.eq(endMonth).nextAll().removeClass("active");
                        }
                        $beginM.addClass("active");
                    }
                }
            } else if ($this.is(".s")) {
                if ($model.find("." + $this.data("s")).hasClass("item" + i)) {
                    $this.val($model.find("." + $this.data("s") + ".item" + i).val());
                } else {
                    $this.val($model.find("." + $this.data("s")).val());
                }
            } else {
                if ($model.find("." + $this.data("v")).hasClass("item" + i)) {
                    $this.val($model.find("." + $this.data("v") + ".item" + i).text());
                } else {
                    $this.val($model.find("." + $this.data("v")).text());
                }
            }
        });
    });
}
//榛樿鏈熸湜瀹炰範鏈堜唤閫夋嫨
var
    nowDate = new Date(),
    nowY = nowDate.getYear() + 1900,
    nowM = nowDate.getMonth();
changeDay
    .children()
    .eq(nowM).addClass("active now_y").attr("data-year",nowY)
    .nextAll().addClass("now_y").attr("data-year",nowY).end()
    .prevAll().attr("data-year",(nowY+1)).end()
    .eq(5).nextAll().addClass("mar_t_5");
//淇濆瓨鎴栧垯鍙栨秷淇敼
var
    $closeBtn = $(".btn[data-flg='0']"),
    $saveBtn = $(".btn[data-flg='1']");
//--------鍙栨秷
$shade.add($closeBtn).on("click", function () {
    closeChange();
});
function closeChange() {
    $changeBox.fadeOut(500);
    $shade.fadeOut(500);
    $changeBox.find("." + popName).fadeOut(500);
    $body.css({
        "overflow": "auto"
    });
    $(".box").css({
        "position": "static",
        "left": "0"
    });
}
$changeBox.on("click", function (e) {
    e.stopPropagation();
});


//-------------------------------淇濆瓨淇℃伅
//
$changeBox.children().wrapInner('<div class="load_box" />');
$body.on("focus", ".v_itm", function () {
    //鍘绘帀杈规
    $(this).removeAttr("style");
});
$saveBtn.on("click", function () {
    var
        inf = {},
        message,
        $messageBox = $changeBox.find("." + popName),
        $message = $messageBox.find(".change_section"),
        isOk = true;
    if ($(this).parents(".expect_change").length) {
        var $monBox = $(this).parents(".expect_change"),
            monArr = [];
        $monBox.find(".change_day_12").children().each(function (i, dom) {
            if ($(dom).is(".active")) {
                monArr.push("'" + $(dom).data("mon") + "'");
            }
        });
        $monBox.find(".mon").val(monArr);
    }
    $message.find(".v_itm").each(function () {
        var $this = $(this);
        if (/^\s*$/.test($this.val()) || ($this.is(".im_phone") && !/^1[0-9]{10}$/.test($this.val()))) {
            $this.css("border-color", "red").addClass("error_yes").on("focus",function(){
                $this.removeClass("error_yes");
            });
            isOk = false;
        }
    });
    if (!isOk) {
        var scrTop = $message.find(".error_yes").eq(0).parent().offset().top - 50;
        $(".change_section_box").animate({
            scrollTop: scrTop
        }, 400);
        return;
    }
    var infArr, infObj, uuid = $(".name"), params;
    if ($message.is(".must_arr")) {
        inf = [];
        $message.each(function (i, dom) {
            infArr = $(dom).find("form").serializeArray();
            infObj = {};
            for (var index in infArr) {
                infObj[infArr[index].name] = infArr[index].value;
            }
            inf[i] = infObj;
        });
    } else {
        infArr = $message.find("form").serializeArray();
        for (var index in infArr) {
            inf[infArr[index].name] = infArr[index].value;
        }
    }
    params = {
        'mod': $messageBox.find(".mod").val(),
        'cont': JSON.stringify(inf)
    };
    message = {
        'guuid': uuid.attr("data-guuid"),
        'ruuid': uuid.attr("data-ruuid"),
        'stype': uuid.attr("data-stype"),
        'params': JSON.stringify(params)
    };
    $.post('/trainee/resume/modify', message, function (d) {
        if (d.code == 100) {
            var _ruuid = d.msg.ruuid, _guuid = d.msg.guuid;
            var modelClass = "." + name;
            if($gdata.attr("data-stype") == "online"){
                $(modelClass).parent().load('/trainee/onresume/modify/' + _ruuid + " " + modelClass, function () {
                    $(modelClass).parent().addClass("complete");
                    //window.history.pushState(null, '', '/trainee/onresume/modify/' + _ruuid);
                });
            }else{
                $(modelClass).parent().load('/trainee/attresume/modify/' + _ruuid + " " + modelClass, function () {
                    $(modelClass).parent().addClass("complete");
                    //window.history.pushState(null, '', '/trainee/attresume/modify/' + _ruuid);
                });
            }

            $gdata.attr("data-guuid", _guuid).attr("data-ruuid", _ruuid);
            closeChange();
        } else {
            alert(d.msg);
        }
    }, 'json');
});
//娣诲姞鏂伴」鐩�
$(".add_item").not(".skill_btn").on("click", function () {
    var $this = $(this),
        close = "<span class=\"change_close_item\"></span>";
    if ($this.parent().find(".change_section").length >= 3) {
        alert("鏁伴噺宸茬粡瓒呰繃涓婇檺锛屽彧鑳藉～鏈€閫傚悎鐨勫摕銆�");
        return;
    }
    $this.prev().animate({
        scrollTop: $this.prev().height()
    }, 800).append($this.prev().find(".change_section").eq(0).clone().prepend(close).find(".v_itm").val('').end());
});
$(".skill_btn").on("click", function () {
    var $this = $(this),
        close = "<span class=\"change_close_item\"></span>";
    if ($this.parent().find(".change_section").length > 2) {
        alert("鏁伴噺宸茬粡瓒呰繃涓婇檺锛屽彧鑳藉～鏈€閫傚悎鐨勫摕銆�");
        return;
    }
    $this.prev()
        .animate({
            scrollTop: $this.prev().height()
        }, 800)
        .append($this.prev().find(".change_section").eq(0).clone()
            .prepend(close)
            .find(".v_itm").val('').end()
            .find(".skill_lev").val('2').end()
            .find(".skill_op").eq(0)
            .addClass("skill_text_ok skill_r_ok")
            .siblings().removeClass("skill_text_ok skill_r_ok").end().end().end());
});
// 鍒犻櫎椤圭洰
$changeBox.on("click",".change_close_item",function () {
    $(this).parent().remove();
});

//榧犳爣绉诲叆淇℃伅鍚庤儗鏅彉鍖�
$body
    .on("mouseover", ".section_item", function () {
        $(this).css("background", "#eee");
    })
    .on("mouseout", ".section_item", function () {
        $(this).css("background", "#fff");
    });
//绠€鍘嗘ā鍧椾笌瑙嗗浘绉诲叆鍏宠仈
var $model = $(".aside_inf").not(".must");
$model.hover(function () {
    var thisView = $(this).data("flg");
    $("." + thisView).css("background", "#eee");
}, function () {
    var thisView = $(this).data("flg");
    $("." + thisView).css("background", "#fff");
});
//绠€鍘嗘ā鍧楅€変腑涓庡彇娑�
$infBox.wrap("<div class='sec_box'></div>");
$model.on("click", function () {
    var
        $modelChild = $(this).find("span"),
        thisView = $(this).data("flg"),
        name = thisView.replace('item_', ''),
        popName = name + "_change",
        $messageBox = $changeBox.find("." + popName),
        mod = $messageBox.find(".mod").val(),
        $thisView = $("." + thisView),
        msg = '';
    $modelChild.toggleClass("aside_inf_flg_ok");
    $(".change_close_item").click();
    changeMsg($thisView, true);
    if ($modelChild.hasClass("aside_inf_flg_ok")) {
        // add
        $thisView.parent().slideDown(500);
        var
            $form = $changeBox.find("." + name + "_change"),
            $message = $form.find(".change_section"),
            inf = {}, infObj, infArr;
        if ($thisView.is(".complete")) {
            if ($message.is(".must_arr")) {
                inf = [];
                $message.each(function (i, dom) {
                    infArr = $(dom).find("form").serializeArray();
                    infObj = {};
                    for (var index in infArr) {
                        infObj[infArr[index].name] = infArr[index].value;
                    }
                    inf[i] = infObj;
                });
            } else {
                infArr = $message.find("form").serializeArray();
                for (var index in infArr) {
                    inf[infArr[index].name] = infArr[index].value;
                }
            }
            msg = JSON.stringify(inf);
        } else {
            msg = '';
        }
        $.post('/trainee/resumemod/check?ruuid=' + $gdata.attr("data-ruuid") + '&mod=' + mod + "&cont=" + msg, function (d) {
            if (d.code != 100) {
                alert(d.msg)
            }
        }, 'json');
    } else {
        //鍙栨秷
        $thisView.parent(".sec_box").slideUp(500);
        $.post('/trainee/resumemod/uncheck?ruuid=' + $gdata.attr("data-ruuid") + '&mod=' + mod + "&cont=''", function (d) {
            if (d.code != 100) {
                alert(d.msg)
            }
        }, 'json');
    }
});

//鍒濆鍖栫畝鍘�
resume_flag.each(function () {
    if (!$(this).is(".aside_inf_flg_ok")) {
        $(".sec_box").find("." + $(this).parent().data("flg")).parent().hide()
    }
});
//妯″潡閫夋嫨鍥哄畾
var $nav = $(".aside"),
    navTop = $nav.offset().top,
    navLeft = $nav.offset().left;
$(window).on("scroll", function () {
    if ($(this).scrollTop() >= navTop) {
        $nav.css({
            position: "fixed",
            left: navLeft
        });
    } else {
        $nav.css({
            position: "absolute",
            left: "auto"
        });
    }
}).on("resize", function () {
    navTop = $nav.offset().top;
    navLeft = $nav.offset().left;
});


//---------------鎶€鑳界啛缁冨害
var $skillChange = $(".skill_change");
$skillChange
    .on("mouseover", ".skill_op", function () {
        $(this).addClass("skill_ok").prevAll().addClass("skill_ok");
    })
    .on("mouseout", ".skill_op", function () {
        $(".skill_op").removeClass("skill_ok");
    })
    .on("click", ".skill_op", function () {
        $(this)
            .siblings().removeClass("skill_r_ok").removeClass("skill_text_ok").end()
            .addClass("skill_text_ok skill_r_ok")
            .prevAll().addClass("skill_r_ok")
            .parents("form").find(".skill_lev").val($(this).data("lev"));
    });


//绠€鍘嗗悕绉颁慨鏀�
var uuid_guuid = $("#gdata");
$(".change_name").on("click", function () {
    var
        $this = $(this),
        value = $this.prev().text() || $this.prev().val();
    if ($this.is(".change_name_save")) {
        if (value == "") {
            alert('绠€鍘嗗悕绉颁笉鑳戒负绌哄摝');
            return false;
        }
        var pattern = /^[^`~!@#$%^&*()=|\\\][\]\{\}:;'\,.<>/?]{1}[^`~!@$%^&()=|\\\][\]\{\}:;'\,.<>?]{0,19}$/;
        if (!pattern.test(value)) {
            alert('鎮ㄧ殑杈撳叆涓嶇鍚堣鑼�');
            return false;
        }
        $this
            .text("")
            .removeClass("change_name_save")
            .prev().remove()
            .end().prev().text(value).show();
        $.post('/trainee/resume/modify', {
            'stype': uuid_guuid.data("stype"),
            'guuid': uuid_guuid.data("guuid"),
            ruuid: uuid_guuid.data("ruuid"),
            params: JSON.stringify({'mod': 'rnme', 'cont': JSON.stringify({'name': value})})
        }, function (d) {
            if (d.code == 100) {
                var _ruuid = d.msg.ruuid, _guuid = d.msg.guuid;
                uuid_guuid.attr("data-guuid", _guuid).attr("data-ruuid", _ruuid);
            } else {
                alert(d.msg);
            }
        }, 'json');
    } else {
        $this
            .text("淇濆瓨")
            .addClass("change_name_save")
            .prev().hide()
            .end().before('<input type=\"text\" class=\"change_name_input\" value=' + value + ' maxlength=\"20\" />');
        $(".change_name_input").focus();
    }
});

$(".nav").on("focus", ".change_name_input", function () {
    var $this = $(this);
    $(window).on("keydown", function (e) {
        if (e.keyCode == 13) {
            $this.next().click();
        }
    })
});

//鍏抽棴椤甸潰浣嗘湭淇濆瓨
//window.onbeforeunload = function() {
//if(1){
//    return "褰撳墠鏁版嵁杩樻病鏈変繚瀛橈紝鍏抽棴鎴栧埛鏂扮獥鍙ｄ細涓㈠け鏁版嵁锛屾槸鍚︾户缁�?";
//}else{
//    return "";
//}
//};


//閫夋嫨妯℃澘寮圭獥
$('.change_model').on('click', function () {
    if (!$("#gdata").attr("data-ruuid")) {
        alert("璇峰厛瀹屽杽鏈熸湜瀹炰範");
        return;
    }
    $('#change_tpl').creatBox();
    $('#element_id').cxScroll();  //鍥剧墖婊氬姩
    //$('#tpl_list a').lightBox();  //棰勮澶у浘
});

//閫夋嫨妯℃澘
$body.on("click", '#tpl_list li', function () {
    $(this).find('img').addClass('active').end().siblings().find('img').removeClass('active');
});
//鎻愪氦閫夋嫨
$('#tpl_submit').on('click', function () {
    var uuid = $(".name"),
        tpluuid = $('#tpl_list img.active').attr('data-val');
    if (uuid.data('guuid') == '') {
        alert('璇峰厛瀹屽杽绠€鍘嗗熀鏈俊鎭�');
        return false;
    }
    var params = {
        'mod': 'temp',
        'cont': JSON.stringify({'guid': tpluuid})
    };
    var message = {
        'guuid': uuid.data("guuid"),
        'ruuid': uuid.data("ruuid"),
        'stype': uuid.data("stype"),
        'params': JSON.stringify(params)
    };
    $.post('/trainee/resume/modify', message, function (d) {
        if (d.code == 100) {
            $('.popup_close').click();
        }
        else alert(d.msg);
    }, 'json');
    $.post('/trainee/resume/modify', message, 'json');
});

//闄勪欢绠€鍘�
function att_resume_onfinish(success, fileuuid, fileurl) {
    if (success) {
        var ruuid = $gdata.attr('data-ruuid');
        $(".has_msg").attr("data-att", '1');
        $.post('/trainee/attach/resume/add',
            {
                ruuid: ruuid,
                params: JSON.stringify({'filepath': fileuuid})
            }, function (data) {
                if (data.code == 100) {
                    $('#iframe').attr('src', data.msg);
                }
                else {
                    alert(data.msg);
                }
            },
            //杩斿洖绫诲瀷
            "json"
        );
    } else {
        alert(fileuuid);
    }

}

//绠€鍘嗛檮浠�
function resume_att_onfinish(success, fileuuid, fileurl) {
    if (success) {
        var ruuid = $gdata.attr('data-ruuid');
        $.post('/trainee/resume/attach',
            {
                ruuid: ruuid,
                params: JSON.stringify({'name': fileuuid, 'filepath': fileuuid})
            }, function (data) {
                if (data.code == 100) {
                    $("#acc_up_if").attr("src", data.msg);
                }
                else {
                    alert(data.msg);
                }
            },
            //杩斿洖绫诲瀷
            "json"
        );
    } else {
        alert(fileuuid);
    }
}
//涓婁紶绠€鍘嗛檮浠�
var
    upBox = $(".filr_box"),
    upShow = $(".show_fil_name"),
    upMsg = $(".up_maseg"),
    upNmae = $(".up_name"),
    fileInput = $("#uploadRatt");
//鏂板缓
$(".add_acc").on("click", function () {
    if (!$("#gdata").attr("data-ruuid")) {
        alert("璇峰厛瀹屽杽鏈熸湜瀹炰範");
        return;
    }
    upBox.show().find("#uppresent").removeClass("fli_c_pre").addClass("up_present");
    fileInput.val('').removeAttr("disabled");
});
//闄勪欢绠€鍘嗗垽鏂�
$(".com_logo_att").on("click", function (e) {
    if (!$("#gdata").attr("data-ruuid")) {
        alert("璇峰厛瀹屽杽鏈熸湜瀹炰範");
        e.stopPropagation();
        e.preventDefault();
    }
});
//纭畾涓婁紶
var changeSid, changeShow;
$body
    .on("click", ".up_present", function () {
        if (/^\s*$/.test(upNmae.val()) || /^\s*$/.test(fileInput.val())) {
            upNmae.on("focus", function () {
                $(this).next().hide()
            }).next().show();
        } else {
            UploadFile('uploadRatt', '.jpg,.png,.jpeg,.pdf,.doc,.docx,.txt', function (success, fileuuid, fileurl) {
                if (success) {
                    var ruuid = $("#gdata").attr("data-ruuid");
                    $.post('/trainee/resume/attach/add', {
                        ruuid: ruuid,
                        params: JSON.stringify({name: upNmae.val(), filepath: fileuuid})
                    }, function (d) {
                        if (d.code == 100) {
                            var clone = $(".fil_model").clone(), path = d.msg.path, sid = d.msg.sid;
                            clone.removeClass("hid").removeClass("fil_model")
                                .find(".up_maseg").data("path", path).text(upNmae.val()).end()
                                .find(".close_file").data("sid", sid);
                            upBox.before(clone);
                            upBox.hide().find("#file_length").val('').end().find(".up_name").val('').end().find(".com_logo").val('');
                        } else {
                            alert(d.msg)
                        }
                    }, 'json');
                } else {
                    alert(fileuuid)
                }
            });
        }
    })
    .on("click", ".fli_c_pre", function () {
        //淇敼闄勪欢
        var noName;
        if (/^\s*$/.test(fileInput.val())) {
            var oldfilr = changeShow.find(".up_maseg").data("path");
            noName = true;
        }
        if (/^\s*$/.test(upNmae.val())) {
            upNmae.on("focus", function () {
                $(this).next().hide()
            }).next().show();
        } else {
            if (noName) {
                $.post('/trainee/resume/attach/modify', {
                    ruuid: ruuid,
                    params: JSON.stringify({name: upNmae.val(), sid: changeSid, filepath: oldfilr})
                }, function (d) {
                    if (d.code == 100) {
                        changeShow.find(".up_maseg").text(upNmae.val()).end().find(".up_maseg").data("path", d.msg.path);
                        upBox.hide().find("#file_length").val('').end().find(".up_name").val('').end().find(".com_logo").val('');
                    } else {
                        alert(d.msg)
                    }
                }, 'json');
            } else {
                UploadFile('uploadRatt', '.jpg,.png,.jpeg,.pdf,.doc,.docx,.txt', function (success, fileuuid, fileurl) {
                    if (success) {
                        $.post('/trainee/resume/attach/modify', {
                            ruuid: ruuid,
                            params: JSON.stringify({name: upNmae.val(), sid: changeSid, filepath: fileuuid})
                        }, function (d) {
                            if (d.code == 100) {
                                changeShow.find(".up_maseg").text(upNmae.val()).end().find(".up_maseg").data("path", d.msg.path);
                                upBox.hide().find(".up_name").val('').end().find(".com_logo").val('');
                            } else {
                                alert(d.msg)
                            }
                        }, 'json');
                    } else {
                        alert(fileuuid)
                    }
                });
            }
        }
    });
//鏄剧ず鏂囦欢澶у皬
fileInput.on("change", function () {
    var inf = "(", size = (fileInput.get(0).files[0].size / 1024 / 1024).toFixed(1);
    if (size > 1) {
        inf += size + "M)"
    } else {
        inf += (fileInput.get(0).files[0].size / 1024).toFixed(1) + "kb)"
    }
    $("#file_length")
        .html(inf);
});
//淇敼闄勪欢
$body.on("click", ".show_fil_name", function () {
    changeShow = $(this);
    upBox.show()
        .find(".up_name").val($(this).find(".up_maseg").text()).end()
        .find(".up_present").removeClass("up_present").addClass("fli_c_pre");
    changeSid = changeShow.find(".close_file").data("sid");
});
//鍒犻櫎闄勪欢
$body.on("click", ".close_file", function (e) {
    var
        $this = $(this),
        sid = $this.data("sid");
    $.post('/trainee/resume/attach/delect', {ruuid: ruuid, params: JSON.stringify({sid: sid})}, function (d) {
        if (d.code == 100) {
            $this.parent().hide();
        } else {
            alert(d.msg)
        }
    }, 'json');
    e.stopPropagation();
});
//鍙栨秷淇敼
$(".up_quit").on("click", function () {
    upBox.hide().find(".up_name").val('').end().find(".com_logo").val('');
    //fileInput.removeAttr("disabled");
});
//鍒ゆ柇骞存湀鏃�
var
    $judge = $(".judg_day"),i= 29,max,
    $judeY =$(".judg_year"),
    $judeM = $(".judg_mon"),
    judgeY,judgeM,
   judgeHtml = $judge.html(),addHtml='';
$judge.html(judgeHtml + "<option value='29'>29</option><option value='30'>30</option><option value='31'>31</option>");
$judeY.add($judeM).on("change",function(){
    judgeY = $judeY.val();
    judgeM = $judeM.val();
    addHtml = '';
    var nowD = $judeM.next().val();
    i = 29;
    max = 31;
    if( judgeM == '02'){
        if ((judgeY % 4 == 0 && judgeY % 100 != 0) || judgeY % 400 == 0) {
            max = 29;
        }else{
            max = 28;
        }
    }else if("01 03 05 07 08 10 12".indexOf(judgeM) != -1){
        max = 31
    }else{
        max = 30
    }
    for(;i <= max;i++){
        addHtml += "<option value=" + i + ">"+ i +"</option>"
    }
    $judge.html(judgeHtml + addHtml).val(nowD);
});
//鑷充粖
$body
    .on("change", '.until_now', function () {
        var $this = $(this);
        if ($this.val() == "0") {
            $this.next().val('0');
        } else {
            if($this.next().val() == '0'){
                $this.next().removeAttr("disabled").val('01');
            }
        }
    })
    .on("change",'.until_nowm',function(){
        var $this = $(this);
        if ($this.val() == "0") {
            $this.prev().val('0');
        } else {
            if($this.prev().val() == '0'){
                $this.prev().removeAttr("disabled").val('2016');
            }
        }
    });
//鏄惁涓婁紶闄勪欢锛岄瑙堬紝涓嬭浇
$(".com_logo_att").on("change",function(){
    UploadFile('uploadatt', '.pdf,.doc,.docx', att_resume_onfinish)
});

$(".has_msg").on("click",function(){
    if($(this).attr("data-att") == 0){
        alert("娌℃湁涓婁紶闄勪欢锛屾棤娉曚笅杞�")
    }else{
        window.open($(this).attr("data-href"));
    }
});



