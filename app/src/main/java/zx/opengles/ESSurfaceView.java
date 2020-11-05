package zx.opengles;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;

/**
 @author Marek Kulawiak
 */

class ESSurfaceView extends GLSurfaceView
{
	protected GLRenderer renderer=null;

	float touchY = 0;
	float touchX = 0;

    public ESSurfaceView(Context context)
    {
        super(context);

        // Stworzenie kontekstu OpenGL ES 2.0.
        setEGLContextClientVersion(2);

        // Przypisanie renderera do widoku.
        renderer = new GLRenderer();
        renderer.setContext(getContext());
        setRenderer(renderer);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
        {
            touchX = event.getX();
            touchY = event.getY();
        } else if (event.getAction() == MotionEvent.ACTION_MOVE)
        {
            renderer.xAngle += (touchX - event.getX())/2f;
            renderer.yAngle += (touchY - event.getY())/2f;

            touchX = event.getX();
            touchY = event.getY();
        }
        return true;
    }

    public GLRenderer getRenderer()
    {
    	return renderer;
    }
}
