package ti.modules.titanium.ui;

import org.appcelerator.titanium.TiContext;
import org.appcelerator.titanium.TiDict;
import org.appcelerator.titanium.proxy.TiViewProxy;
import org.appcelerator.titanium.proxy.TiWindowProxy;
import org.appcelerator.titanium.util.Log;
import org.appcelerator.titanium.util.TiConfig;
import org.appcelerator.titanium.view.TiUIView;

import android.app.Activity;

public class TabProxy extends TiViewProxy
{
	private static final String LCAT = "TabProxy";
	private static final boolean DBG = TiConfig.LOGD;

	private TiWindowProxy win;

	public TabProxy(TiContext tiContext, Object[] args) {
		super(tiContext, args);
	}

	@Override
	public TiUIView createView(Activity activity) {
		return null;
	}

	public void open(TiWindowProxy win, TiDict options) {
		if (win != null && this.win == null) {
			this.win = win;
			this.win.setTabProxy(this);
			options.put("tabOpen", true);
			win.open(options);
		}
	}

	public void close(TiDict options) {
		if (win != null) {
			win.close(options);
			win = null;
		}
	}
}
