/**
 *  命名空间管理
 */
var namespace = {
    Register: function () {
        var arg = arguments[0];
        var arr = arg.split('.');
        var context = window;
        for (var i = 0; i < arr.length; i++) {
            var str = arr[i];
            if (!context[str]) {
                context[str] = {};
            }
            context = context[str];
        };
    }
};