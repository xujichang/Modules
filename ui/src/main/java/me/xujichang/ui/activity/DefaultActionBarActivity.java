package me.xujichang.ui.activity;

import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import android.widget.TextView;

import me.xujichang.ui.actionbar.ActionWhich;
import me.xujichang.ui.actionbar.DefaultActionBar;
import me.xujichang.ui.actionbar.IActionBar;

/**
 * Des: 单独对ACtionBar做处理
 *
 * @author xujichang
 * <p>
 * created by 2018/8/24-下午4:09
 */
public abstract class DefaultActionBarActivity extends XBaseActivity {

    private DefaultActionBar defaultActionBar;

    @Override
    protected IActionBar onObtainActionBar() {
        defaultActionBar = new DefaultActionBar();
        return defaultActionBar;
    }

    protected void setLeftText(String text) {
        defaultActionBar.setLeftText(text);
    }

    public void setRightText(String text) {
        defaultActionBar.setRightText(text);
    }

    public void setLeftImage(@DrawableRes int id) {
        defaultActionBar.setLeftImage(getDrawableWithSc(id));
    }

    public void setRightImage(@DrawableRes int id) {
        defaultActionBar.setRightImage(getDrawableWithSc(id));
    }

    /**
     * ==================================获取属性====================================================
     */
    protected TextView getActionbarTitle() {
        return defaultActionBar.getActionBarTitle();
    }

    public ImageView getActionbarLeftImg() {
        return defaultActionBar.getImageView(ActionWhich.LEFT_IMAGE);
    }

    public TextView getActionbarLeftText() {
        return defaultActionBar.getTextView(ActionWhich.LEFT_TEXT);
    }

    public ImageView getActionbarRightImg() {
        return defaultActionBar.getImageView(ActionWhich.RIGHT_IMAGE);
    }

    public TextView getActionbarRightText() {
        return defaultActionBar.getTextView(ActionWhich.RIGHT_TEXT);
    }
}
