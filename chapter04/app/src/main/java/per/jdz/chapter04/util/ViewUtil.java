package per.jdz.chapter04.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * ClassName: ViewUtil
 * Description:
 *
 * @Author: Jdz
 * @Create: 2023/9/28 - 9:10
 */
public class ViewUtil {

    public static void hideOneInputMethod(Activity act, View view) {
        // 从系统服务中获取输入法管理器
        InputMethodManager inputMethodManager = (InputMethodManager) act.getSystemService(Context.INPUT_METHOD_SERVICE);
        // 关闭屏幕上的输入法软键盘
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
