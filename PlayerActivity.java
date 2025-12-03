package com.media3.exampleq;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.activity.*;
import androidx.annotation.*;
import androidx.annotation.experimental.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.arch.core.*;
import androidx.core.*;
import androidx.customview.*;
import androidx.customview.poolingcontainer.*;
import androidx.emoji2.*;
import androidx.emoji2.viewsintegration.*;
import androidx.emoji2.widget.*;
import androidx.exifinterface.*;
import androidx.fragment.*;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.interpolator.*;
import androidx.lifecycle.livedata.*;
import androidx.lifecycle.livedata.core.*;
import androidx.lifecycle.runtime.*;
import androidx.lifecycle.viewmodel.*;
import androidx.lifecycle.viewmodel.savedstate.*;
import androidx.loader.*;
import androidx.media.*;
import androidx.media3.exoplayer.*;
import androidx.media3.session.*;
import androidx.media3.ui.*;
import androidx.recyclerview.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.savedstate.*;
import androidx.tracing.*;
import androidx.vectordrawable.*;
import androidx.vectordrawable.animated.*;
import androidx.versionedparcelable.*;
import androidx.viewpager.*;
import com.bumptech.glide.*;
import com.bumptech.glide.gifdecoder.*;
import com.media3.exampleq.CustomPlayerView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.RepeatModeUtil;
import androidx.media3.common.util.Util;
import androidx.media3.common.Player;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Format;
import androidx.media3.common.TrackGroup;
import androidx.media3.datasource.DefaultHttpDataSource;
import androidx.media3.datasource.DefaultDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.dash.DashMediaSource;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import androidx.media3.exoplayer.smoothstreaming.SsMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ProgressiveMediaSource;
import androidx.media3.exoplayer.trackselection.TrackSelection;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.RenderersFactory;
import androidx.media3.exoplayer.SeekParameters;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.CaptionStyleCompat;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.PlayerControlView;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.SubtitleView;
import androidx.media3.ui.TimeBar;

import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;
import androidx.media3.exoplayer.drm.LocalMediaDrmCallback;
import androidx.media3.exoplayer.drm.FrameworkMediaDrm;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManagerProvider;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.DefaultLoadControl;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.DefaultRenderersFactory;
import androidx.media3.exoplayer.drm.DrmSessionManager;

// Tambahkan di Add source directly (di atas class PlayerActivity)

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;
import android.widget.BaseAdapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Toast;
import android.graphics.Color;
import android.content.res.ColorStateList;

import android.content.res.Configuration;
import com.bumptech.glide.Glide;
import android.net.Uri;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.Gravity; 

import android.view.ViewGroup; 

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import android.graphics.drawable.GradientDrawable;


import android.view.Window; 
import android.view.WindowManager;
import android.content.Context; 
import android.content.pm.ActivityInfo;
import androidx.core.view.WindowCompat; 
import androidx.core.view.WindowInsetsControllerCompat;
import android.os.Handler;
import android.os.Looper;


public class PlayerActivity extends AppCompatActivity {
	
	private String title = "";
	private String url = "";
	private String useragent = "";
	private String referer = "";
	private String origin = "";
	private String key = "";
	private String scheme = "";
	private String cookie = "";
	ExoPlayer player;
	final PlayerActivity activity = this;
	private double active_position = 0;
	private String category = "";
	private double active_position_cat = 0;
	private double gone_visible = 0;
	private String categoryName = "";
	private double activ_position2 = 0;
	int pos;
	private String selectedCategory = "";
	private boolean isLandscape = false;
	private double dpToPx = 0;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<String> spin = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> spinn = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> originalMap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map_playerView = new ArrayList<>();
	
	private CustomPlayerView playerView;
	private LinearLayout linear_image_hide;
	private Button imageview1;
	private LinearLayout linear8;
	private TextView textview1;
	private ListView listview2;
	private Button button2;
	private LinearLayout linear1;
	private LinearLayout linear6;
	private Button button1;
	private LinearLayout linear7;
	private Button button_show_cat;
	private LinearLayout linear2;
	private LinearLayout linear_cat;
	private ListView listview_category;
	private RecyclerView rvCategory;
	private LinearLayout linear_ch;
	private ListView listview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.player);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		// 1. INISIALISASI SEMUA VIEW HANYA SATU KALI
		// categoryRecycler adalah variabel Java yang dipasangkan ke ID View category_recycler
		
		playerView = findViewById(R.id.playerView);
		listview1 = findViewById(R.id.listview1);
		listview_category = findViewById(R.id.listview_category);
		listview2 = findViewById(R.id.listview1);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		
		linear_cat = findViewById(R.id.linear_cat);
		linear_ch = findViewById(R.id.linear_ch);
		/// ... (Kode findViewById Anda) ...
		
		//
		
		// ... (Kode setOnItemClickListener Anda) ...
		
		playerView = findViewById(R.id.playerView);
		linear_image_hide = findViewById(R.id.linear_image_hide);
		imageview1 = findViewById(R.id.imageview1);
		linear8 = findViewById(R.id.linear8);
		textview1 = findViewById(R.id.textview1);
		listview2 = findViewById(R.id.listview2);
		button2 = findViewById(R.id.button2);
		linear1 = findViewById(R.id.linear1);
		linear6 = findViewById(R.id.linear6);
		button1 = findViewById(R.id.button1);
		linear7 = findViewById(R.id.linear7);
		button_show_cat = findViewById(R.id.button_show_cat);
		linear2 = findViewById(R.id.linear2);
		linear_cat = findViewById(R.id.linear_cat);
		listview_category = findViewById(R.id.listview_category);
		rvCategory = findViewById(R.id.rvCategory);
		linear_ch = findViewById(R.id.linear_ch);
		listview1 = findViewById(R.id.listview1);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setVisibility(View.GONE);
				linear8.setVisibility(View.VISIBLE);
			}
		});
		
		linear8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		listview2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (helper != null) {
					helper.releasePlayer(); // Asumsi Anda punya method releasePlayer() di Media3Helper
				}
				title = map.get((int)_position).get("title").toString();
				helper.setTitle(title);
				key = map.get((int)_position).get("drm-license").toString();
				referer = map.get((int)_position).get("referer").toString();
				helper.setReferer(referer);
				useragent = map.get((int)_position).get("user-agent").toString();
				helper.setUserAgent(useragent);
				scheme = map.get((int)_position).get("drm-type").toString();
				origin = map.get((int)_position).get("origin").toString();
				helper.setOrigin(origin);
				cookie = map.get((int)_position).get("cookie").toString();
				helper.setCookie(cookie);
				url = map.get((int)_position).get("url").toString();
				if (scheme.equals("clearkey") || key.contains(":") && ! key.contains("http") && ! key.contains("https") ) {
					helper.initializePlayerWithClearKey(url, key, scheme);
					SketchwareUtil.showMessage(getApplicationContext(), "clearkey");
				} else {
					helper.initializePlayerWithLicense(url, key, scheme);
					SketchwareUtil.showMessage(getApplicationContext(), "widevine");
				}
				// KODE YANG HARUS DITEMPEL DI AKHIR onITEMCLICK ANDA
				active_position = _position;
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				
				// KODE YANG HARUS DITEMPEL DI AKHIR onITEMCLICK ANDA
				active_position = _position;
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				
				active_position = _position;
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				linear8.setVisibility(View.GONE);
				imageview1.setVisibility(View.VISIBLE);
			}
		});
		
		button_show_cat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		listview_category.setOnScrollListener(new AbsListView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(AbsListView abs, int _scrollState) {
				
			}
			
			@Override
			public void onScroll(AbsListView abs, int _firstVisibleItem, int _visibleItemCount, int _totalItemCount) {
				
			}
		});
		
		listview_category.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				
				
				// 1. Ambil kategori yang dipilih
				selectedCategory = spin.get((int)_position); 
				
				// 2. LOGIKA TOMBOL (Kode Anda)
				button1.setText(selectedCategory.concat("⬇️")); 
				
				// 3. SET HIGHLIGHT DAN REFRESH (Kode Tambahan)
				active_position_cat = _position;
				((BaseAdapter)listview_category.getAdapter()).notifyDataSetChanged();
				
				// 4. PANGGIL FUNGSI FILTER (KODE KRITIS!)
				activity._filterChannels(selectedCategory); // <--- INI ADALAH KODE YANG HARUS ADA
				
				
				active_position = -1;
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (helper != null) {
					helper.releasePlayer(); // Asumsi Anda punya method releasePlayer() di Media3Helper
				}
				title = map.get((int)_position).get("title").toString();
				helper.setTitle(title);
				key = map.get((int)_position).get("drm-license").toString();
				referer = map.get((int)_position).get("referer").toString();
				helper.setReferer(referer);
				useragent = map.get((int)_position).get("user-agent").toString();
				helper.setUserAgent(useragent);
				scheme = map.get((int)_position).get("drm-type").toString();
				origin = map.get((int)_position).get("origin").toString();
				helper.setOrigin(origin);
				cookie = map.get((int)_position).get("cookie").toString();
				helper.setCookie(cookie);
				url = map.get((int)_position).get("url").toString();
				if (scheme.equals("clearkey") || key.contains(":") && ! key.contains("http") && ! key.contains("https") ) {
					helper.initializePlayerWithClearKey(url, key, scheme);
					SketchwareUtil.showMessage(getApplicationContext(), "clearkey");
				} else {
					helper.initializePlayerWithLicense(url, key, scheme);
					SketchwareUtil.showMessage(getApplicationContext(), "widevine");
				}
				// KODE YANG HARUS DITEMPEL DI AKHIR onITEMCLICK ANDA
				active_position = _position;
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				
				// KODE YANG HARUS DITEMPEL DI AKHIR onITEMCLICK ANDA
				active_position = _position;
				((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
				
				active_position = _position;
				textview1.setText(map.get((int)_position).get("category").toString());
			}
		});
	}
  private void initializeLogic() {

		getWindow().setStatusBarColor(Color.TRANSPARENT);
		getWindow().setNavigationBarColor(Color.TRANSPARENT);
		
		getWindow().getDecorView().setSystemUiVisibility(
		View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
		| View.SYSTEM_UI_FLAG_LAYOUT_STABLE
		);

		_setDa();

		_ply_ch();

		_setCategoryAdapter();

		_helper();

		_sav();

		AndroidUtilities.checkDisplaySize(this, getResources().getConfiguration());

		active_position = -1;

		active_position_cat = -1;

		button_show_cat.setVisibility(View.GONE);

		button1.setVisibility(View.VISIBLE);

		linear_cat.setVisibility(View.VISIBLE);

		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button_show_cat.setVisibility(View.VISIBLE);

				button1.setVisibility(View.GONE);

				linear_cat.setVisibility(View.GONE);
			}
		});

		button_show_cat.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				button_show_cat.setVisibility(View.GONE);

				button1.setVisibility(View.VISIBLE);

				linear_cat.setVisibility(View.VISIBLE);
			}
		});

		// KODE LAMA ANDA:
		// linear_cat.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFFEEEEEE,0xFFFFFDEE}));
		
		// --- KODE BARU UNTUK linear_cat di initializeLogic() ---
		
		// Background List Kategori harus sedikit lebih terang dari background utama (#1E1E1E)
		linear_cat.setBackgroundColor(Color.parseColor("#1E1E1E"));
		

		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c) { this.setStroke(a, b); this.setColor(c); return this; } }.getIns((int)5, 0xFF00BCD4, 0xFF1E1E1E));

		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)7, 0xFF000000));

		button1.setBackground(new GradientDrawable(GradientDrawable.Orientation.BR_TL, new int[] {0xFF00BCD4,0xFFFFFDEE}));

		linear8.setVisibility(View.GONE);

		imageview1.setVisibility(View.GONE);

		activity._setRippleEffect(button2);
		activity._setRippleEffect(imageview1);

		textview1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)9, (int)6, 0xFF00BCD4, 0xFF2A2A2A));

	}

	

	

	@Override

	public void onBackPressed() {

		if (helper != null && helper.isFullscreen()) {
			helper.onHideCustomView();
			
			return;
		}
		
		
		super.onBackPressed();

	}

	public void _helper() {

		helper = new Media3Helper(this, playerView);

		helper.setControls(linear8, imageview1);

		helper.getPlayerView().setControllerVisibilityListener(
		new PlayerView.ControllerVisibilityListener() {
			@Override
			public void onVisibilityChanged(int visibility) {
				if (helper.isFullScreen()) {
					if (visibility == View.VISIBLE) {
						imageview1.setVisibility(View.VISIBLE);
					} else {
						imageview1.setVisibility(View.GONE);
					}
				} else {
					imageview1.setVisibility(View.GONE);
				}
			}
		}
		);

		helper.setOnFullscreenChangedListener(isFullscreen -> {
			if (isFullscreen) {
				linear8.setVisibility(View.VISIBLE);
				imageview1.setVisibility(View.VISIBLE);
			} else {
				linear8.setVisibility(View.GONE);
				imageview1.setVisibility(View.GONE);
			}
		});

	}

	public Media3Helper helper;

	@Override

	public void onResume() {

		super.onResume();

		try{
			if (helper != null) {

				helper.onResume();

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Override

	public void onPause() {

		super.onPause();

		try{
			if (helper != null) {

				helper.onPause();

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Override

	public void onStop() {

		super.onStop();

		try{
			if (helper != null) {

				helper.onStop();

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Override

	public void onDestroy() {

		super.onDestroy();

		try{
			if (helper != null) {

				helper.onDestroy();

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Override

	public void onStart() {

		super.onStart();

		try{
			if (helper != null) {

				helper.onStart();

			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	
	@Override
	public void finish() {
		super.finish();
		try{
			if (helper != null) {
				helper.finish();
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
	}
	

	@RequiresApi(api = Build.VERSION_CODES.O)
	@Override
	public void onUserLeaveHint() {
		super.onUserLeaveHint();
		try{
			if (helper != null) {
				helper.enterPictureInPictureMode();
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
	}
	
	@Override
	public void onPictureInPictureModeChanged(boolean isInPictureInPictureMode, Configuration newConfig) {
		super.onPictureInPictureModeChanged(isInPictureInPictureMode, newConfig);
		try{
			if (helper != null) {
				helper.setControllerVisibility(!isInPictureInPictureMode);
			}
		}catch(Exception e){
			SketchwareUtil.showMessage(getApplicationContext(), e.toString());
		}
	}
	

	{

	}

	

	

	public void _setDa() {

		// Di PlayerActivity.java, di dalam More Block _setDa,
		// Ganti seluruh kode eksekusi di sini.
		
		AssetManager assetManager = getAssets();
		InputStream input = null; 
		String text = ""; 
		
		try {
			input = assetManager.open("channel.json");
			int size = input.available();
			byte[] buffer = new byte[size];
			input.read(buffer);
			input.close();
			
			// convert buffer ke string
			text = new String(buffer); 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// 1. Parsing data
		map = new Gson().fromJson(text, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType()); 
		originalMap.clear();
		originalMap.addAll(map); 
		
		// 2. Logika Ekstraksi Kategori Unik ke List String 'spin'
		Set<String> uniqueCategories = new HashSet<>();
		uniqueCategories.add("SEMUA"); // Tambahkan kategori default "SEMUA"
		for (HashMap<String, Object> item : originalMap) {
			if (item.containsKey("category") && item.get("category") != null) {
				uniqueCategories.add(item.get("category").toString());
			}
		}
		spin.clear();
		spin.addAll(uniqueCategories); 
		
		// --- KODE SORTING KATEGORI (Mengatasi Acak) ---
		Collections.sort(spin, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				// PENTING: Pastikan "SEMUA" selalu di urutan pertama
				if (s1.equals("SEMUA")) {
					return -1;
				}
				if (s2.equals("SEMUA")) {
					return 1;
				}
				// Sorting normal untuk kategori lainnya
				return s1.compareToIgnoreCase(s2);
			}
		});
		// ------------------------------------
		
		
		// 4. Default: Tampilkan semua data channel di listview1 (Adapter Anonim yang LENGKAP)
		listview1.setAdapter(new BaseAdapter() {
			private LayoutInflater getLayoutInflater() {
				return (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
			
			// --- TIGA METHOD WAJIB ---
			@Override
			public int getCount() {
				return map.size();
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return map.get(position);
			}
			// ------------------------------------------
			
			@Override
			public View getView(final int _position, View _v, ViewGroup _container) {
				LayoutInflater _inflater = getLayoutInflater();
				View _view = _v;
				if (_view == null) {
					_view = _inflater.inflate(R.layout.cust, null);
				}
				
				// FindView: Sesuaikan ID View Anda
				final LinearLayout linear3 = _view.findViewById(R.id.linear3); 
				final LinearLayout linear2 = _view.findViewById(R.id.linear2);
				final TextView textview1 = _view.findViewById(R.id.textview1);
				final ImageView imageview1 = _view.findViewById(R.id.imageview1);
				
				// <<< FIX ERROR VARIABEL DAN GRADIENTDRAWABLE SINTAKSIS >>>
				float density = getResources().getDisplayMetrics().density; // FIX: Deklarasi hanya sekali
				
				
				// --- KODE MARGIN CHANNEL (Mengatasi Mepet) ---
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
				);
				
				int margin_vertical_px = (int) (6 * density); // Margin Atas/Bawah 8dp
				int margin_horizontal_px = (int) (10 * density); // Margin Kiri/Kanan 10dp
				
				// Set margin: kiri, atas, kanan, bawah
				params.setMargins(margin_horizontal_px, margin_vertical_px, margin_horizontal_px, margin_vertical_px); 
				linear3.setLayoutParams(params);
				
				
				// --- LOGIKA HIGHLIGHT ITEM AKTIF (linear3) ---
				
				// GradientDrawable untuk linear3 (Container Item Channel)
				GradientDrawable itemBackground = new GradientDrawable();
				itemBackground.setCornerRadius(9 * density); // Radius Sudut: 15dp
				
				if (_position == active_position) {
					// AKTIF: Stroke Cyan, Background Dark Gray
					itemBackground.setStroke((int)(10 * density), 0xFF00BCD4); // Stroke 2dp, Warna Cyan
					itemBackground.setColor(0xFF2A2A2A); // Background Lighter Dark Gray
				} else {
					// NON-AKTIF: Tanpa Stroke, Background Darker Gray
					itemBackground.setStroke((int)0, 0xFF000000); 
					itemBackground.setColor(0xFF5A5A5A); // Background Darkest Gray
				}
				
				linear3.setBackground(itemBackground); // Terapkan background ke linear3
				
				
				// Pengaturan untuk linear2 (Background Logo)
				GradientDrawable logoBackground = new GradientDrawable();
				logoBackground.setCornerRadius(10 * density); // Radius Sudut: 10dp
				logoBackground.setColor(0xFF2A2A2A); // Warna Logo Container: Lighter Dark Gray
				linear2.setBackground(logoBackground); // Terapkan background ke linear2
				
				
				// 1. Gambar Logo
				Glide.with(getApplicationContext()).load(Uri.parse(map.get((int)_position).get("logo").toString())).into(imageview1);
				
				// 4. Pengaturan Teks
				textview1.setText(map.get((int)_position).get("title").toString());
				textview1.setTextColor(Color.WHITE); 
				
				
				activity._setRippleEffect(linear3);   
				
				return _view;
			}
		}); 
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		

}
  public void _sav() {

		// PlayerActivity.java - di dalam onCreate
		SharedPreferences prefs = getSharedPreferences("PLAYER_PREFS", Context.MODE_PRIVATE);
		
		// Dapatkan mode terakhir. Defaultnya adalah RESIZE_MODE_FIT (biasanya 0 atau 1)
		// Kita gunakan 0 sebagai nilai default aman jika belum ada data tersimpan.
		int lastMode = prefs.getInt("KEY_RESIZE_MODE", 0); 
		

	}

	

	

	public void _filterChannels(final String _category) {

		// Di PlayerActivity.java, di method public void _filterChannels(final String _category)
		
		// HANYA isi kode eksekusi untuk More Block: filterChannels(String category)
		
		// Buat daftar baru untuk hasil filter
		ArrayList<HashMap<String, Object>> filteredList = new ArrayList<>();
		
		// Logika menggunakan ARGUMEN '_category' yang diteruskan.
		if (_category.equals("SEMUA")) { // DIGANTI menjadi _category
			// Jika memilih "SEMUA", gunakan salinan data asli
			filteredList.addAll(originalMap);
		} else {
			// Jika memilih kategori spesifik, filter originalMap
			for (HashMap<String, Object> item : originalMap) {
				if (item.containsKey("category") && item.get("category") != null) {
					// Bandingkan nilai kategori item dengan ARGUMEN '_category'
					if (item.get("category").toString().equals(_category)) { // DIGANTI menjadi _category
						filteredList.add(item);
					}
				}
			}
		}
		
		// Perbarui ListMap utama ('map') dan ListAdapter
		map.clear(); // Hapus data ListMap 'map' yang lama
		map.addAll(filteredList); // Masukkan data hasil filter
		
		// Perbarui tampilan ListView
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		
		// Gulir (scroll) listview ke atas
		listview1.setSelection(0);
		
		
		
		

	}

	

	

	public void _fulls() {

		

	}

	

	

	public void _setCategoryAdapter() {

		
		// --- KODE LENGKAP DI DALAM MORE BLOCK: _setCategoryAdapter ---  
		
		final ListView listview_category = findViewById(R.id.listview_category);   
		
		listview_category.setAdapter(new BaseAdapter() {  
			private LayoutInflater getLayoutInflater() {  
				return (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);  
			}  
			
			@Override  
			public int getCount() { return spin.size(); }  
			@Override  
			public long getItemId(int position) { return position; }  
			@Override  
			public Object getItem(int position) { return spin.get(position); }  
			
			@Override
			public View getView(final int _position, View _v, ViewGroup _container) {
				LayoutInflater _inflater = getLayoutInflater();
				View _view = _v;
				if (_view == null) {
					_view = _inflater.inflate(R.layout.kat, null);
				}
				
				// FindView: Sesuaikan ID View Anda
				final TextView tvCategory = _view.findViewById(R.id.tvCategory);   
				final LinearLayout linear1 = _view.findViewById(R.id.linear1);   
				final LinearLayout linear2 = _view.findViewById(R.id.linear2);   
				
				// <<< FIX ERROR VARIABEL DAN GRADIENTDRAWABLE SINTAKSIS >>>
				float density = getResources().getDisplayMetrics().density; // FIX: Deklarasi hanya sekali
				
				
				// --- KODE MARGIN CHANNEL (Mengatasi Mepet) ---
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
				);
				
				int margin_vertical_px = (int) (8 * density); // Margin Atas/Bawah 8dp
				int margin_horizontal_px = (int) (10 * density); // Margin Kiri/Kanan 10dp
				
				// Set margin: kiri, atas, kanan, bawah
				params.setMargins(margin_horizontal_px, margin_vertical_px, margin_horizontal_px, margin_vertical_px); 
				linear2.setLayoutParams(params);
				
				
				// --- LOGIKA HIGHLIGHT ITEM AKTIF (linear3) ---
				
				// GradientDrawable untuk linear3 (Container Item Channel)
				GradientDrawable itemBackground1 = new GradientDrawable();
				itemBackground1.setCornerRadius(9 * density); // Radius Sudut: 15dp
				
				if (_position == active_position_cat) {
					// AKTIF: Stroke Cyan, Background Dark Gray
					itemBackground1.setStroke((int)(6 * density), 0xFF00BCD4); // Stroke 2dp, Warna Cyan
					itemBackground1.setColor(0xFF2A2A2A); // Background Lighter Dark Gray
				} else {
					// NON-AKTIF: Tanpa Stroke, Background Darker Gray
					itemBackground1.setStroke((int)0, 0xFF000000); 
					itemBackground1.setColor(0xFF1A1A1A); // Background Darkest Gray
				}
				
				linear1.setBackground(itemBackground1); // Terapkan background ke linear3
				
				
				// Pengaturan untuk linear2 (Background Logo)
				GradientDrawable logoBackground1 = new GradientDrawable();
				logoBackground1.setCornerRadius(10 * density); // Radius Sudut: 10dp
				logoBackground1.setColor(0xFF2A2A2A); // Warna Logo Container: Lighter Dark Gray
				linear2.setBackground(logoBackground1); // Terapkan background ke linear2
				
				
				
				
				
				// 4. Pengaturan Teks
				tvCategory.setText(spin.get(_position));
				tvCategory.setTextColor(Color.WHITE); 
				
				activity._setRippleEffect(linear1);   
				
				return _view;  
			}  
		});   
		
		((BaseAdapter)listview_category.getAdapter()).notifyDataSetChanged();
		
		
		
		
		
		
		
		
		
		

	}

	

	

	public void _setRippleEffect(final View _linear) {

		// KODE DI DALAM _setRippleEffect(final View _linear)
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			_linear.setForeground(new RippleDrawable(
			ColorStateList.valueOf(Color.parseColor("#40FFFFFF")), 
			null, 
			null
			));
		} else {
			_linear.setClickable(true);
			_linear.setFocusable(true);
		}
		

	}

	

	

	public void _loadCategory(final double _pos) {

		int p = (int) pos;
		
		if (p < 0 || p >= spin.size()) return;
		
		String name = spin.get(p);
		
		button1.setText(name + "⬇️");
		
		active_position_cat = p;
		
		_filterChannels(name);
		
		if (rvCategory.getAdapter() instanceof CategoryAdapter) {
			((CategoryAdapter) rvCategory.getAdapter()).setActive(p);
		}

	}

	

	

	public void _ply_ch() {

		listview2.setAdapter(new BaseAdapter() {
			private LayoutInflater getLayoutInflater() {
				return (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			}
			
			// --- TIGA METHOD WAJIB ---
			@Override
			public int getCount() {
				return map.size();
			}
			
			@Override
			public long getItemId(int position) {
				return position;
			}
			
			@Override
			public Object getItem(int position) {
				return map.get(position);
			}
			// ------------------------------------------
			
			@Override
			public View getView(final int _position, View _v, ViewGroup _container) {
				LayoutInflater _inflater = getLayoutInflater();
				View _view = _v;
				if (_view == null) {
					_view = _inflater.inflate(R.layout.cust, null);
				}
				
				// FindView: Sesuaikan ID View Anda
				final LinearLayout linear3 = _view.findViewById(R.id.linear3); 
				final LinearLayout linear2 = _view.findViewById(R.id.linear2);
				final TextView textview1 = _view.findViewById(R.id.textview1);
				final ImageView imageview1 = _view.findViewById(R.id.imageview1);
				
				// <<< FIX ERROR VARIABEL DAN GRADIENTDRAWABLE SINTAKSIS >>>
				float density = getResources().getDisplayMetrics().density; // FIX: Deklarasi hanya sekali
				
				
				// --- KODE MARGIN CHANNEL (Mengatasi Mepet) ---
				LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
				);
				
				int margin_vertical_px = (int) (6 * density); // Margin Atas/Bawah 8dp
				int margin_horizontal_px = (int) (10 * density); // Margin Kiri/Kanan 10dp
				
				// Set margin: kiri, atas, kanan, bawah
				params.setMargins(margin_horizontal_px, margin_vertical_px, margin_horizontal_px, margin_vertical_px); 
				linear3.setLayoutParams(params);
				
				
				// --- LOGIKA HIGHLIGHT ITEM AKTIF (linear3) ---
				
				// GradientDrawable untuk linear3 (Container Item Channel)
				GradientDrawable itemBackground = new GradientDrawable();
				itemBackground.setCornerRadius(9 * density); // Radius Sudut: 15dp
				
				if (_position == active_position) {
					// AKTIF: Stroke Cyan, Background Dark Gray
					itemBackground.setStroke((int)(10 * density), 0xFF00BCD4); // Stroke 2dp, Warna Cyan
					itemBackground.setColor(0xFF2A2A2A); // Background Lighter Dark Gray
				} else {
					// NON-AKTIF: Tanpa Stroke, Background Darker Gray
					itemBackground.setStroke((int)0, 0xFF000000); 
					itemBackground.setColor(0xFF5A5A5A); // Background Darkest Gray
				}
				
				linear3.setBackground(itemBackground); // Terapkan background ke linear3
				
				
				// Pengaturan untuk linear2 (Background Logo)
				GradientDrawable logoBackground = new GradientDrawable();
				logoBackground.setCornerRadius(10 * density); // Radius Sudut: 10dp
				logoBackground.setColor(0xFF2A2A2A); // Warna Logo Container: Lighter Dark Gray
				linear2.setBackground(logoBackground); // Terapkan background ke linear2
				
				
				// 1. Gambar Logo
				Glide.with(getApplicationContext()).load(Uri.parse(map.get((int)_position).get("logo").toString())).into(imageview1);
				
				// 4. Pengaturan Teks
				textview1.setText(map.get((int)_position).get("title").toString());
				textview1.setTextColor(Color.WHITE); 
				
				
				activity._setRippleEffect(linear3);   
				
				return _view;
			}
		}); 
		((BaseAdapter)listview2.getAdapter()).notifyDataSetChanged();
public class Listview2Adapter extends BaseAdapter {

		

		ArrayList<HashMap<String, Object>> _data;

		

		public Listview2Adapter(ArrayList<HashMap<String, Object>> _arr) {

			_data = _arr;

		}

		

		@Override

		public int getCount() {

			return _data.size();

		}

		

		@Override

		public HashMap<String, Object> getItem(int _index) {

			return _data.get(_index);

		}

		

		@Override

		public long getItemId(int _index) {

			return _index;

		}

		

		@Override

		public View getView(final int _position, View _v, ViewGroup _container) {

			LayoutInflater _inflater = getLayoutInflater();

			View _view = _v;

			if (_view == null) {

				_view = _inflater.inflate(R.layout.cust, null);

			}

			

			final LinearLayout linear3 = _view.findViewById(R.id.linear3);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final TextView textview1 = _view.findViewById(R.id.textview1);

			final ImageView imageview1 = _view.findViewById(R.id.imageview1);

			

			if (_position == active_position) {

				linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)18, 0xFF00BCD4, 0xFFEEEEEE));

			} else {

				linear3.setBackground(new GradientDrawable() {
					public GradientDrawable getIns(int a, int b, int c, int d) {
						this.setCornerRadius(a);
						this.setStroke(b, c);
						this.setColor(d);
						return this;
					}
				}.getIns(
				(int)15,          // Radius Sudut: 15dp
				(int)0,           // Lebar Stroke: 0dp
				0xFF000000,       
				0xFF1A1A1A        // Warna Latar Belakang: Dark Gray
				));
				
				// 3. Pengaturan untuk linear2 (Background Logo - Lebih kontras)
				linear2.setBackground(new GradientDrawable() {
					public GradientDrawable getIns(int a, int b, int c, int d) {
						this.setCornerRadius(a); 
						this.setStroke(b, c);    
						this.setColor(d);        
						return this;
					}
				}.getIns(
				(int)10,          
				(int)0,           
				0xFF000000,       
				0xFF2A2A2A        // Warna Logo Container: Lighter Dark Gray 
				));
				
				

			}

			

			return _view;

		}

	}

	

	public class Listview_categoryAdapter extends BaseAdapter {

		

		ArrayList<HashMap<String, Object>> _data;

		

		public Listview_categoryAdapter(ArrayList<HashMap<String, Object>> _arr) {

			_data = _arr;

		}

		

		@Override

		public int getCount() {

			return _data.size();

		}

		

		@Override

		public HashMap<String, Object> getItem(int _index) {

			return _data.get(_index);

		}

		

		@Override

		public long getItemId(int _index) {

			return _index;

		}

		

		@Override

		public View getView(final int _position, View _v, ViewGroup _container) {

			LayoutInflater _inflater = getLayoutInflater();

			View _view = _v;

			if (_view == null) {

				_view = _inflater.inflate(R.layout.kat, null);

			}

			

			final LinearLayout linear1 = _view.findViewById(R.id.linear1);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final TextView tvCategory = _view.findViewById(R.id.tvCategory);

			

			return _view;

		}

	}

	

	public class Listview1Adapter extends BaseAdapter {

		

		ArrayList<HashMap<String, Object>> _data;

		

		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {

			_data = _arr;

		}

		

		@Override

		public int getCount() {

			return _data.size();

		}

		

		@Override

		public HashMap<String, Object> getItem(int _index) {

			return _data.get(_index);

		}

		

		@Override

		public long getItemId(int _index) {

			return _index;

		}

		

		@Override

		public View getView(final int _position, View _v, ViewGroup _container) {

			LayoutInflater _inflater = getLayoutInflater();

			View _view = _v;

			if (_view == null) {

				_view = _inflater.inflate(R.layout.cust, null);

			}

			

			final LinearLayout linear3 = _view.findViewById(R.id.linear3);

			final LinearLayout linear2 = _view.findViewById(R.id.linear2);

			final TextView textview1 = _view.findViewById(R.id.textview1);

			final ImageView imageview1 = _view.findViewById(R.id.imageview1);

			

			if (_position == active_position) {

				linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)15, (int)18, 0xFF00BCD4, 0xFFEEEEEE));

			} else {

				linear3.setBackground(new GradientDrawable() {
					public GradientDrawable getIns(int a, int b, int c, int d) {
						this.setCornerRadius(a);
						this.setStroke(b, c);
						this.setColor(d);
						return this;
					}
				}.getIns(
				(int)15,          // Radius Sudut: 15dp
				(int)0,           // Lebar Stroke: 0dp
				0xFF000000,       
				0xFF1A1A1A        // Warna Latar Belakang: Dark Gray
				));
				
				// 3. Pengaturan untuk linear2 (Background Logo - Lebih kontras)
				linear2.setBackground(new GradientDrawable() {
					public GradientDrawable getIns(int a, int b, int c, int d) {
						this.setCornerRadius(a); 
						this.setStroke(b, c);    
						this.setColor(d);        
						return this;
					}
				}.getIns(
				(int)10,          
				(int)0,           
				0xFF000000,       
				0xFF2A2A2A        // Warna Logo Container: Lighter Dark Gray 
				));
				
				

			}

			

			return _view;

		}

	}

	

	@Deprecated

	public void showMessage(String _s) {

		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();

	}

	

	@Deprecated

	public int getLocationX(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[0];

	}

	

	@Deprecated

	public int getLocationY(View _v) {

		int _location[] = new int[2];

		_v.getLocationInWindow(_location);

		return _location[1];

	}

	

	@Deprecated

	public int getRandom(int _min, int _max) {

		Random random = new Random();

		return random.nextInt(_max - _min + 1) + _min;

	}

	

	@Deprecated

	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {

		ArrayList<Double> _result = new ArrayList<Double>();

		SparseBooleanArray _arr = _list.getCheckedItemPositions();

		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {

			if (_arr.valueAt(_iIdx))

			_result.add((double)_arr.keyAt(_iIdx));

		}

		return _result;

	}

	

	@Deprecated

	public float getDip(int _input) {

		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());

	}

	

	@Deprecated

	public int getDisplayWidthPixels() {

		return getResources().getDisplayMetrics().widthPixels;

	}

	

	@Deprecated

	public int getDisplayHeightPixels() {

		return getResources().getDisplayMetrics().heightPixels;

	}

}
