package git.artdeell.mojo;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/** Procedural, lightweight pixel-art scenery with bounded animation work. */
public final class AnimatedHomeBackgroundView extends View {
 public static final String PREFS="oryn_home_background",KEY_ID="background_id",KEY_ANIMATION="animation_enabled",KEY_INTENSITY="animation_intensity",DEFAULT_ID="overworld";
 private final Paint p=new Paint(Paint.ANTI_ALIAS_FLAG); private String scene=DEFAULT_ID; private boolean animate=true,active,homeVisible=true; private float intensity=.65f; private long started;
 public AnimatedHomeBackgroundView(Context c){super(c);init();} public AnimatedHomeBackgroundView(Context c,AttributeSet a){super(c,a);init();} public AnimatedHomeBackgroundView(Context c,AttributeSet a,int d){super(c,a,d);init();}
 private void init(){setClickable(false);setFocusable(false);loadPreferences();}
 public void loadPreferences(){SharedPreferences s=getContext().getSharedPreferences(PREFS,Context.MODE_PRIVATE);scene=s.getString(KEY_ID,DEFAULT_ID);animate=s.getBoolean(KEY_ANIMATION,true);intensity=s.getInt(KEY_INTENSITY,65)/100f;invalidate();}
 public void setScene(String id,boolean enabled,float strength){scene=id==null?DEFAULT_ID:id;animate=enabled;intensity=Math.max(0,Math.min(1,strength));invalidate();}
 public void setHomeVisible(boolean visible){homeVisible=visible;if(visible&&animate&&active)invalidate();}
 @Override protected void onAttachedToWindow(){super.onAttachedToWindow();active=true;started=System.currentTimeMillis();if(animate&&getWindowVisibility()==VISIBLE)postInvalidateOnAnimation();}
 @Override protected void onDetachedFromWindow(){active=false;super.onDetachedFromWindow();}
 @Override protected void onWindowVisibilityChanged(int v){super.onWindowVisibilityChanged(v);if(v==VISIBLE&&active&&animate&&hasWindowFocus())invalidate();}
 @Override public void onWindowFocusChanged(boolean focused){super.onWindowFocusChanged(focused);if(focused&&active&&animate)invalidate();}
 @Override protected void onDraw(Canvas c){super.onDraw(c);float w=getWidth(),h=getHeight();if(w<=0||h<=0)return;float t=animate?(System.currentTimeMillis()-started)/1000f:0;drawScene(c,w,h,t);if(animate&&active&&getWindowVisibility()==VISIBLE&&hasWindowFocus())postInvalidateDelayed(40);}
 private void drawScene(Canvas c,float w,float h,float t){
  int top,bottom; switch(scene){case "cherry":top=0xff29263d;bottom=0xff6b526c;break;case "snow":top=0xff182d43;bottom=0xff9ab8c8;break;case "night":top=0xff080e28;bottom=0xff35446a;break;case "nether":top=0xff24090f;bottom=0xff812a25;break;case "ocean":top=0xff092c42;bottom=0xff087b87;break;case "aurora":top=0xff07172d;bottom=0xff234a58;break;case "rain":top=0xff182630;bottom=0xff46545b;break;default:top=0xff102b36;bottom=0xff49745c;}
  p.setShader(new LinearGradient(0,0,0,h,top,bottom,Shader.TileMode.CLAMP));c.drawRect(0,0,w,h,p);p.setShader(null);float u=Math.max(5,w/100f);
  if(scene.equals("night")||scene.equals("aurora")||scene.equals("cherry"))for(int i=0;i<58;i++){float x=f(i*.61803f+.13f)*w,y=f(i*.371f+.07f)*h*.58f,tw=animate?(float)Math.sin(t*1.6+i)*.5f+.5f:.5f;p.setColor(Color.argb((int)(90+140*tw),230,240,255));c.drawCircle(x,y,Math.max(.7f,u*.12f),p);}
  if(scene.equals("aurora"))for(int b=0;b<4;b++){Path a=new Path();for(int x=0;x<=w;x+=Math.max(8,(int)(w/45))){float y=h*(.18f+b*.045f)+(float)Math.sin(x/w*7+t*.35f+b)*h*.055f;if(x==0)a.moveTo(x,y);else a.lineTo(x,y);}p.setColor(Color.argb((int)(22+intensity*28),65,255,195));p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(h*.035f);c.drawPath(a,p);p.setStyle(Paint.Style.FILL);}
  if(scene.equals("ocean"))for(int i=0;i<8;i++){float x=f(i*.173f+t*.018f*intensity)*w,y=h*(.18f+i*.075f);p.setColor(Color.argb(25,150,235,255));c.drawOval(x,y,x+w*.2f,y+h*.11f,p);}
  float g=h*.68f;p.setColor(scene.equals("snow")?0xffb6d1dd:scene.equals("nether")?0xff49171b:scene.equals("ocean")?0xff064354:scene.equals("cherry")?0xff273a36:scene.equals("night")||scene.equals("aurora")?0xff101b2d:scene.equals("rain")?0xff253c3a:0xff234b36);c.drawRect(0,g,w,h,p);
  p.setColor(scene.equals("snow")?0xffe0edf0:scene.equals("nether")?0xff6b2427:scene.equals("ocean")?0xff0b5964:scene.equals("cherry")?0xff466b4c:scene.equals("night")||scene.equals("aurora")?0xff1b2e42:scene.equals("rain")?0xff354f47:0xff3c7044);for(int i=0;i<22;i++){float x=i*w/20f;c.drawRect(x,g+(float)Math.sin(i*2.1f)*h*.055f,x+w/18f,h,p);}
  for(int i=0;i<7;i++){float x=(i+.4f)*w/7f,b=g+(float)Math.sin(i*2.1f)*h*.035f;if(scene.equals("ocean")){p.setColor(0xff123f50);c.drawRect(x,b-h*.04f,x+u*2,b+h*.2f,p);p.setColor(0xff2e8d91);c.drawRect(x-u,b-h*.08f,x+u*3,b-h*.04f,p);}else if(scene.equals("nether")){p.setColor(0xff30151a);c.drawRect(x,b-h*.32f,x+u*2,b,p);p.setColor(0xffa33b25);c.drawRect(x-u,b-h*.32f,x+u*3,b-h*.27f,p);p.setColor(0xffff8b32);c.drawRect(x+u,b-h*.21f,x+u*1.5f,b-h*.16f,p);}else{p.setColor(0xff3e3027);c.drawRect(x,b-h*.2f,x+u*1.4f,b,p);p.setColor(scene.equals("cherry")?0xffb66c9a:scene.equals("snow")?0xffc5dce4:0xff24503a);c.drawRect(x-u*1.4f,b-h*.3f,x+u*2.8f,b-h*.16f,p);c.drawRect(x-u*.8f,b-h*.38f,x+u*2.2f,b-h*.27f,p);if(scene.equals("cherry")){p.setColor(0xffffb8d8);c.drawRect(x-u,b-h*.34f,x+u*1.5f,b-h*.31f,p);}}}
  int n=animate?(int)(24*intensity):0;for(int i=0;i<n;i++){float x=f(i*.754f+(float)Math.sin(t*.15f+i)*.035f)*w,y=f(i*.417f+t*(.035f+(i%5)*.009f))*h;if(scene.equals("rain")){p.setColor(Color.argb(95,175,205,220));p.setStrokeWidth(Math.max(1,u*.12f));c.drawLine(x,y,x-u*.25f,y+u*1.8f,p);}else{p.setColor(scene.equals("cherry")?0xffffb7d7:scene.equals("snow")?0xfff1fbff:scene.equals("nether")?0xffff7339:scene.equals("ocean")?0xff9bf6ef:0xffd8ecff);p.setAlpha(100+(i%5)*28);c.drawCircle(x,y,Math.max(1.2f,u*.13f),p);}}
  p.setColor(Color.argb(42,0,5,10));c.drawRect(0,0,w,h,p);
 }
 private static float f(float v){return v-(float)Math.floor(v);}
}