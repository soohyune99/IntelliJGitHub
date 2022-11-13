/*
* /board/reply.html
* */

let replyService = (function(){
    function add(reply, callback, error){
        $.ajax({
            url: "/reply/new",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }

    function getList(boardNumber, callback, error){
        $.ajax({
            url: "/reply/list/" + boardNumber,
            type: "get",
            success: function(replies, status, xhr){
                if(callback){
                    callback(replies);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }

    function read(replyNumber, callback, error){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "get",
            success: function(reply, status, xhr){
                if(callback){
                    callback(reply);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });

    }

    function remove(replyNumber, callback, error){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "delete",
            success: function(reply, status, xhr){
                if(callback){
                    callback(reply);
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });

    }

    function modify(reply, callback, error){
        $.ajax({
            url: "/reply/" + replyNumber,
            type: "patch",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8",
            success: function(result, status, xhr){
                if(callback){
                    callback(result);
                    console.log("수정됨");
                }
            },
            error: function(xhr, status, err){
                if(error){
                    error(err);
                }
            }
        });
    }
    return {add: add, getList: getList, read: read, remove: remove, modify: modify}
})();





























