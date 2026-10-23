package git.artdeell.mojo.fragments;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import git.artdeell.mojo.AnimatedHomeBackgroundView;
import git.artdeell.mojo.R;
import git.artdeell.mojo.Tools;

public final class HomeBackgroundSettingsFragment extends Fragment {
 private static final String[] IDS={"cherry","snow","night","overworld","nether","ocean","aurora","rain"};
 private static final String[] NAMES={"Cherry Blossom","Snowfall","Night Sky","Overworld","Nether","Ocean","Aurora","Rainy World"};
 private static final String[] DESCS={"Falling petals and a soft pink grove","Quiet snow over frosted terrain","Stars over a deep twilight horizon","A peaceful blocky green landscape","Crimson cliffs and drifting embers","Deep water with moving light","Northern lights flowing across the sky","Rain falling over a moody world"};
 private String selected=AnimatedHomeBackgroundView.DEFAULT_ID;
 private boolean animation=true;
 private int intensity=65;
 private AnimatedHomeBackgroundView preview;
 private LinearLayout cards;
 private Switch animationSwitch;
 private TextView intensityLabel;
 private SeekBar intensitySeek;

 @Nullable @Override public View onCreateView(@NonNull android.view.LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle state){
  SharedPreferences prefs=requireContext().getSharedPreferences(AnimatedHomeBackgroundView.PREFS,0);
  selected=prefs.getString(AnimatedHomeBackgroundView.KEY_ID,AnimatedHomeBackgroundView.DEFAULT_ID);
  animation=prefs.getBoolean(AnimatedHomeBackgroundView.KEY_ANIMATION,true);
  intensity=prefs.getInt(AnimatedHomeBackgroundView.KEY_INTENSITY,65);
  ScrollView scroll=new ScrollView(requireContext());scroll.setFillViewport(true);scroll.setBackgroundColor(Color.rgb(5,10,14));
  LinearLayout root=new LinearLayout(requireContext());root.setOrientation(LinearLayout.VERTICAL);root.setPadding(dp(16),dp(14),dp(16),dp(24));scroll.addView(root);
  TextView title=text("Home Screen Background",22,Color.WHITE,true);root.addView(title);
  TextView subtitle=text("Choose a world for your launcher. Preview it, then apply.",13,0xffa7b9c2,false);addTop(root,subtitle,4);
  preview=new AnimatedHomeBackgroundView(requireContext());preview.setScene(selected,animation,intensity/100f);
  LinearLayout previewCard=card();previewCard.setPadding(dp(8),dp(8),dp(8),dp(8));previewCard.addView(preview,new LinearLayout.LayoutParams(-1,dp(180)));addTop(root,previewCard,14);
  TextView selectedName=text(getName(selected),17,Color.WHITE,true);selectedName.setTag("selected_name");root.addView(selectedName);
  TextView selectedDesc=text(getDescription(selected),12,0xffa7b9c2,false);selectedDesc.setTag("selected_desc");addTop(root,selectedDesc,3);
  TextView choose=text("AVAILABLE WORLDS",11,0xff45d7b2,true);addTop(root,choose,18);
  cards=new LinearLayout(requireContext());cards.setOrientation(LinearLayout.VERTICAL);root.addView(cards);rebuildCards();
  animationSwitch=new Switch(requireContext());animationSwitch.setText("Background animation");animationSwitch.setTextColor(Color.WHITE);animationSwitch.setTextSize(14);animationSwitch.setChecked(animation);addTop(root,animationSwitch,16);
  animationSwitch.setOnCheckedChangeListener((button,checked)->{animation=checked;updatePreview();rebuildCards();});
  intensityLabel=text("Animation intensity · "+intensity+"%",13,0xffd5e0e5,false);addTop(root,intensityLabel,10);
  intensitySeek=new SeekBar(requireContext());intensitySeek.setMax(100);intensitySeek.setProgress(intensity);root.addView(intensitySeek,new LinearLayout.LayoutParams(-1,dp(36)));
  intensitySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){public void onProgressChanged(SeekBar b,int v,boolean user){intensity=v;intensityLabel.setText("Animation intensity · "+v+"%");updatePreview();}public void onStartTrackingTouch(SeekBar b){}public void onStopTrackingTouch(SeekBar b){}});
  LinearLayout actions=new LinearLayout(requireContext());actions.setOrientation(LinearLayout.HORIZONTAL);actions.setGravity(Gravity.CENTER_VERTICAL);addTop(root,actions,14);
  Button reset=new Button(requireContext());reset.setText("Reset to Default");actions.addView(reset,new LinearLayout.LayoutParams(0,dp(48),1));
  Button apply=new Button(requireContext());apply.setText("Apply Background");actions.addView(apply,new LinearLayout.LayoutParams(0,dp(48),1));
  reset.setOnClickListener(v->{selected=AnimatedHomeBackgroundView.DEFAULT_ID;animation=true;intensity=65;animationSwitch.setChecked(true);intensitySeek.setProgress(65);updatePreview();rebuildCards();saveAndReturn();});
  apply.setOnClickListener(v->saveAndReturn());
  return scroll;
 }
 private void saveAndReturn(){requireContext().getSharedPreferences(AnimatedHomeBackgroundView.PREFS,0).edit().putString(AnimatedHomeBackgroundView.KEY_ID,selected).putBoolean(AnimatedHomeBackgroundView.KEY_ANIMATION,animation).putInt(AnimatedHomeBackgroundView.KEY_INTENSITY,intensity).apply();Tools.backToMainMenu(requireActivity());}
 private void updatePreview(){if(preview!=null)preview.setScene(selected,animation,intensity/100f);if(getView()!=null){TextView n=getView().findViewWithTag("selected_name"),d=getView().findViewWithTag("selected_desc");if(n!=null)n.setText(getName(selected));if(d!=null)d.setText(getDescription(selected));}}
 private void rebuildCards(){if(cards==null)return;cards.removeAllViews();int width=getResources().getConfiguration().screenWidthDp;int cols=width>=700?4:2;LinearLayout row=null;for(int i=0;i<IDS.length;i++){if(i%cols==0){row=new LinearLayout(requireContext());row.setOrientation(LinearLayout.HORIZONTAL);cards.addView(row,new LinearLayout.LayoutParams(-1,-2));}final String id=IDS[i];LinearLayout tile=card();tile.setPadding(dp(5),dp(5),dp(5),dp(8));tile.setClickable(true);tile.setFocusable(true);GradientDrawable bg=rounded(id.equals(selected)?0xff123a39:0xff101a20,id.equals(selected)?0xff36d6b1:0xff29383f,12);tile.setBackground(bg);LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(0,-2,1);lp.setMargins(dp(4),dp(4),dp(4),dp(4));row.addView(tile,lp);AnimatedHomeBackgroundView thumb=new AnimatedHomeBackgroundView(requireContext());thumb.setScene(id,false,.35f);tile.addView(thumb,new LinearLayout.LayoutParams(-1,dp(82)));TextView label=text(NAMES[i],12,Color.WHITE,true);label.setGravity(Gravity.CENTER);LinearLayout.LayoutParams tlp=new LinearLayout.LayoutParams(-1,-2);tlp.topMargin=dp(7);tile.addView(label,tlp);TextView badge=text(id.equals(selected)?"✓ SELECTED":"✦ ANIMATED",9,id.equals(selected)?0xff52e2bf:0xff93a9b4,true);badge.setGravity(Gravity.CENTER);tile.addView(badge);tile.setOnClickListener(v->{selected=id;updatePreview();rebuildCards();});}}
 private LinearLayout card(){LinearLayout l=new LinearLayout(requireContext());l.setOrientation(LinearLayout.VERTICAL);l.setBackground(rounded(0xff0b151a,0xff203039,14));return l;}
 private GradientDrawable rounded(int fill,int stroke,int radius){GradientDrawable d=new GradientDrawable();d.setColor(fill);d.setCornerRadius(dp(radius));d.setStroke(dp(1),stroke);return d;}
 private TextView text(String s,int size,int color,boolean bold){TextView v=new TextView(requireContext());v.setText(s);v.setTextSize(size);v.setTextColor(color);v.setFontFeatureSettings("kern");if(bold)v.setTypeface(android.graphics.Typeface.DEFAULT,android.graphics.Typeface.BOLD);return v;}
 private void addTop(LinearLayout root,View v,int margin){LinearLayout.LayoutParams p=new LinearLayout.LayoutParams(-1,-2);p.topMargin=dp(margin);root.addView(v,p);}
 private int dp(float value){return (int)(value*getResources().getDisplayMetrics().density+.5f);}
 private String getName(String id){for(int i=0;i<IDS.length;i++)if(IDS[i].equals(id))return NAMES[i];return "Overworld";}
 private String getDescription(String id){for(int i=0;i<IDS.length;i++)if(IDS[i].equals(id))return DESCS[i];return DESCS[3];}
}