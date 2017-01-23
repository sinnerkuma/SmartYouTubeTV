package com.liskovsoft.smartyoutubetv;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.liskovsoft.browser.xwalk.XWalkBrowserActivity;
import com.liskovsoft.smartyoutubetv.other.SmartYouTubeTVCore;

public class SmartYouTubeTVActivity extends XWalkBrowserActivity {
    private SmartYouTubeTVCore mCore;

    @Override
    protected void onCreate(Bundle icicle) {
        mCore = new SmartYouTubeTVCore(this);

        super.onCreate(icicle);
    }

    @Override
    protected void initController(Bundle icicle) {
        setController(mCore.createController(icicle));
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        event = mCore.doTranslateKeys(event);
        return super.dispatchKeyEvent(event);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(mCore.transformIntent(intent));
    }
}
