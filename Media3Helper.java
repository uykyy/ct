



package com.media3.exampleq;

/*
* This is the source code of Media3
* It is licensed under GNU GPL v. 2 or later.
* You should have received a copy of the license in this archive (see LICENSE).
*
* Copyright Gandalf Dev "Sketchware Pro", 2024-2025.
*/
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.util.Base64;
import android.util.Log;
import java.util.HashMap;
import java.util.Map;
import android.app.PictureInPictureParams;
import android.os.Build;
import android.os.Bundle;
import android.util.Rational;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Rational;
import android.util.TypedValue;
import java.net.URL;
import java.util.UUID;
import android.view.HapticFeedbackConstants;
import android.view.InputDevice;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.Gravity;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

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
import androidx.media3.common.TrackSelectionParameters;
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

import java.util.ArrayList;
import java.util.List;

import java.util.UUID;
import android.os.Handler;
import android.os.Looper;

public class Media3Helper {
	
	private Context context;
	private PlayerView playerView;
	private DefaultTrackSelector trackSelector;
	private ExoPlayer exoPlayer;
	private TrackSelectionHelper trackSelectionHelper;
	
	private String userAgent;
	private String cookie;
	private String referer;
	private String origin;
	
	private View mCustomView;
	private int mOriginalSystemUiVisibility;
	
	private ViewGroup originalParent;
	private int originalIndex;
	private ViewGroup.LayoutParams originalLayoutParams;
    
    private LinearLayout topLayout;
	private TextView titleView;
	
	private PictureInPictureParams.Builder pipBuilder;
    
    private TrackSelectionParameters trackSelectionParameters;
	private DefaultRenderersFactory renderersFactory;
    
    
private View linear8;
private View imageview1;

public void setControls(View linear8, View imageview1) {
    this.linear8 = linear8;
    this.imageview1 = imageview1;
}
    // Penanda apakah sedang fullscreen
private boolean isFullscreen = false;

public boolean isFullscreen() {
    return isFullscreen;
}
	// Media3Helper.java (hanya bagian constructor yang diubah)

// Media3Helper.java (Constructor)

public Media3Helper(Context context, PlayerView playerView) {
    this.context = context;
    this.playerView = playerView;
    keepScreen(true);
    
    setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
    
    // **[Perbaikan 1]: Inisialisasi Fondasi NON-UI di sini**
    trackSelector = new DefaultTrackSelector(context);
	renderersFactory = new DefaultRenderersFactory(context)
	.setEnableDecoderFallback(true)
	.forceEnableMediaCodecAsynchronousQueueing();
    trackSelectionParameters = new TrackSelectionParameters.Builder(context).build();
    
    // [UI Setup] Sekarang hanya memanggil UI setup secara tertunda
    AndroidUtilities.runOnUIThread(() -> {
        initializePlayer();
    });
}

// ... (sisa kode initializePlayer() tetap sama)

    
    public void setTitle(String string) {
    // [Perbaikan Kritis]: Guard Clause untuk mencegah NPE jika dipanggil terlalu cepat
    if (titleView == null) {
        return; 
    }

    // Lanjutkan dengan pengecekan visibility seperti sebelumnya
    if (playerView == null || TextUtils.isEmpty(string)) {
        titleView.setVisibility(View.GONE);
        return;
    }
    
    titleView.setVisibility(View.VISIBLE);
    titleView.setText(string);
}

	
	private void initializePlayer() {
    try {
        
        
        // Line 1: Mengatur Visibilitas UI Sistem
  ((Activity) context).getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
        
        // Line 2: Inisialisasi Player
     
		playerView.setUseController(true); 
		
		trackSelectionHelper = new TrackSelectionHelper(context, playerView, exoPlayer, trackSelector);
		
		playerView.setRepeatToggleModes(RepeatModeUtil.REPEAT_TOGGLE_MODE_ALL);
		playerView.setShowSubtitleButton(true);
		//playerView.setShowVrButton(true);
		setFullscreenButtonClickListener();
        
        // Di dalam Media3Helper.java -> initializePlayer()

// ... baris sebelumnya
playerView.setShowSubtitleButton(true);
//playerView.setShowVrButton(true);
setFullscreenButtonClickListener();

// === KODE UNTUK MENGHILANGKAN TOMBOL NAVIGASI YANG DILINGKARI ===

// Menonaktifkan tombol "Skip Previous" (Panah Mundur/Awal Track)
playerView.setShowPreviousButton(false); 

// Menonaktifkan tombol "Rewind" (Mundur 10 detik)
playerView.setShowRewindButton(false); 

// Menonaktifkan tombol "Fast Forward" (Maju 10 detik)
playerView.setShowFastForwardButton(false); 

// Menonaktifkan tombol "Skip Next" (Panah Maju/Akhir Track)
playerView.setShowNextButton(false);



// =============================================================

// ... baris berikutnya (Kustomisasi Tampilan Kontrol)

        
        // Line 3: Kustomisasi Tampilan Kontrol (Menambahkan Title View, dll.)
        final int titleViewPaddingHorizontal = AndroidUtilities.dp(12);
		final int titleViewPaddingVertical = AndroidUtilities.dp(0);
		FrameLayout centerView = playerView.findViewById(R.id.exo_controls_background);
		
		LinearLayout topLayout = new LinearLayout(context);
		topLayout.setOrientation(LinearLayout.HORIZONTAL);
		topLayout.setBackgroundResource(R.color.ui_controls_background);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
		LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
		topLayout.setLayoutParams(layoutParams);
		topLayout.setPadding(AndroidUtilities.dp(8), AndroidUtilities.getStatusBarHeight(context), AndroidUtilities.dp(8), AndroidUtilities.dp(8));
        topLayout.setVisibility(View.GONE);
		centerView.addView(topLayout);
        
        layoutParams = new LinearLayout.LayoutParams(
		AndroidUtilities.dp(35), AndroidUtilities.dp(35));
        
        ImageView backImageView = new ImageView(context);
        int padding = AndroidUtilities.dp(4);
        backImageView.setPadding(padding, padding, padding, padding);
        backImageView.setImageResource(R.drawable.ic_arrow_back_white);
        topLayout.addView(backImageView, layoutParams);
        backImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity)v.getContext()).finish();
			}
		});
        
        layoutParams = new LinearLayout.LayoutParams(
		LinearLayout.LayoutParams.WRAP_CONTENT, AndroidUtilities.dp(35));
		
		titleView = new TextView(context);
		titleView.setTextColor(Color.WHITE);
		titleView.setPadding(AndroidUtilities.dp(12), 0, AndroidUtilities.dp(12), 0);
		titleView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
		titleView.setVisibility(View.GONE);
		titleView.setMaxLines(1);
		titleView.setEllipsize(TextUtils.TruncateAt.END);
		titleView.setTextDirection(View.TEXT_DIRECTION_LOCALE);
        titleView.setGravity(Gravity.CENTER_VERTICAL);
		topLayout.addView(titleView, layoutParams);
        
		ImageButton trackImageView = playerView.findViewById(R.id.exo_track);
		trackImageView.setImageResource(R.drawable.ic_settings_ethernet_white);
		trackImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showTrackSelection();
			}
		});
		
		ImageButton pipImageView = playerView.findViewById(R.id.exo_pip);
		pipImageView.setImageResource(R.drawable.ic_flip_to_front_white);
		pipImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				enterPictureInPictureMode();
			}
		});
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			pipBuilder = new PictureInPictureParams.Builder();
		} else {
			pipImageView.setVisibility(View.GONE);
		}
		
		ImageButton muteButton = playerView.findViewById(R.id.exo_mute);
		muteButton.setImageResource(R.drawable.ic_volume_down_white);
		muteButton.setOnClickListener(new View.OnClickListener() {
			private boolean isMuted = false;
			
			@Override
			public void onClick(View v) {
				if (isMuted) {
					mutePlayer(false);
					muteButton.setImageResource(R.drawable.ic_volume_down_white);
				} else {
					mutePlayer(true);
					muteButton.setImageResource(R.drawable.ic_volume_off_white);
				}
				isMuted = !isMuted;
			}
		});
        
        ImageButton resizeButton = playerView.findViewById(R.id.exo_resize);
		resizeButton.setImageResource(R.drawable.ic_aspect_ratio_24dp);
		resizeButton.setOnClickListener(new View.OnClickListener() {
			private int currentMode = 0;
			private int[] resizeModes = {
				AspectRatioFrameLayout.RESIZE_MODE_FIT,
				AspectRatioFrameLayout.RESIZE_MODE_FILL,
				AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH,
				AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT,
				AspectRatioFrameLayout.RESIZE_MODE_ZOOM
			};
			private String[] modeNames = {
				"FIT",
				"FILL",
				"FIXED_WIDTH",
				"FIXED_HEIGHT",
				"ZOOM"
			};
			
			@Override
			public void onClick(View v) {
				currentMode = (currentMode + 1) % resizeModes.length;
				AndroidUtilities.runOnUIThread(() -> {
                    playerView.setResizeMode(resizeModes[currentMode]);
					AndroidUtilities.showToast(modeNames[currentMode]);
				});
			}
		});
        
    } catch (Exception e) {
        e.printStackTrace();
        // Fungsi ini akan menampilkan pesan error yang sebenarnya di layar Anda.
        AndroidUtilities.showToast("CRASH INIT: " + e.getMessage()); 
    }
}
	
	public void keepScreen(boolean keep) {
		if (keep) {
			((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		} else {
			((Activity) context).getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
	}
	
	public void enterPictureInPictureMode() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
			Rational aspectRatio = new Rational(/*playerView.getWidth()*/ 16, /*playerView.getHeight()*/9);
			pipBuilder.setAspectRatio(aspectRatio);
			((Activity)context).enterPictureInPictureMode(pipBuilder.build());
		}
	}
	
	private boolean isInPictureInPictureModeCompat() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
			return ((Activity) context).isInPictureInPictureMode();
		}
		return false;
	}
	
 public void setControllerVisibility(boolean visible) {
		if (!visible) {
			playerView.hideController();
		} else {
			playerView.showController();
		}
	}
	
	public void mutePlayer(boolean mute) {
		if (exoPlayer != null) {
			exoPlayer.setVolume(mute ? 0f : 1f);
		}
	}
	
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
	public void setCookie(String cookie) {
		this.cookie = cookie;
	}
	
	public void setReferer(String referer) {
		this.referer = referer;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
    
    
	
	
// =======================
// 1️⃣ Interface Listener
// =======================
// =======================
// 1️⃣ Interface Listener
// =======================
public interface OnFullscreenChangedListener {
    void onFullscreenChanged(boolean isFullscreen);
}

// =======================
// 2️⃣ Field Listener
// =======================
private OnFullscreenChangedListener fullscreenChangedListener;

// =======================
// 3️⃣ Setter Listener
// =======================
public void setOnFullscreenChangedListener(OnFullscreenChangedListener listener) {
    this.fullscreenChangedListener = listener;
}

// =======================
// 4️⃣ Variabel penanda fullscreen
// =======================
private boolean isFullscreenState = false; // selalu update state

public boolean isFullScreen() {
    return isFullscreenState;
}

// =======================
// 5️⃣ Fullscreen Button Click
// =======================
public void setFullscreenButtonClickListener() {
    playerView.setFullscreenButtonClickListener(new PlayerView.FullscreenButtonClickListener() {
        @Override
        public void onFullscreenButtonClick(boolean isFullscreen) {
            AndroidUtilities.runOnUIThread(() -> {
                if (isFullscreen) {
                    onShowCustomView(playerView);
                } else {
                    onHideCustomView();
                }
            });
        }
    });
}

// =======================
// 6️⃣ onShowCustomView
// =======================
public void onShowCustomView(View view) {
    isFullscreen = true;
    if (mCustomView != null) {
        onHideCustomView();
        return;
    }

    mCustomView = view;
    isFullscreenState = true;

    // Simpan layout asli
    mOriginalSystemUiVisibility = ((Activity) context).getWindow().getDecorView().getSystemUiVisibility();
    originalParent = (ViewGroup) playerView.getParent();
    originalIndex = originalParent.indexOfChild(playerView);
    originalLayoutParams = playerView.getLayoutParams();
    originalParent.removeView(playerView);

    FrameLayout decor = (FrameLayout) ((Activity) context).getWindow().getDecorView();
    decor.addView(playerView, new FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
    ));

    decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN |
            View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
            View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

    ((Activity) context).setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    // 🔹 Ganti visibility linear8 & imageview1
    if (linear8 != null) linear8.setVisibility(View.VISIBLE);
    if (imageview1 != null) imageview1.setVisibility(View.VISIBLE);

    // Listener fullscreen
    if (fullscreenChangedListener != null) {
        fullscreenChangedListener.onFullscreenChanged(true);
    }
}

// =======================
// 7️⃣ onHideCustomView
// =======================
public void onHideCustomView() {
    isFullscreen = false;
    if (mCustomView != null) {

        FrameLayout decor = (FrameLayout) ((Activity) context).getWindow().getDecorView();

        // Hapus fullscreen player dari decor
        decor.removeView(playerView);

        // Balik player ke parent asli
        if (originalParent != null && playerView.getParent() == null) {
            originalParent.addView(playerView, originalIndex, originalLayoutParams);
        }

        mCustomView = null;
        isFullscreenState = false;

        // 🔥 Delay kecil untuk memastikan layout betul-betul kembali
        new Handler().postDelayed(() -> {
            // Balik UI System
            decor.setSystemUiVisibility(mOriginalSystemUiVisibility);

            // Balik orientasi
            ((Activity) context).setRequestedOrientation(
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            );

            // GONE linear8 & imageview1
            if (linear8 != null) linear8.setVisibility(View.GONE);
            if (imageview1 != null) imageview1.setVisibility(View.GONE);

            // Listener fullscreen
            if (fullscreenChangedListener != null) {
                fullscreenChangedListener.onFullscreenChanged(false);
            }
        }, 0);// 100–150ms adalah sweet spot
    }
}

// =======================
// 8️⃣ Handle Back Press
// =======================
public boolean handleBackPress() {
    if (isFullscreen()) {
        
        onHideCustomView();
        isFullscreen = false;
        return true;
    }
    return false;
}


    
    
	
	public void initializeDrmPlayer(final String videoUrl) {
		Uri videoUri = Uri.parse(videoUrl);
		MediaItem mediaItem = new MediaItem.Builder()
		.setUri(videoUri)
		.build();
		
		exoPlayer.setMediaItem(mediaItem);
		exoPlayer.prepare();
		exoPlayer.play();
        
        AndroidUtilities.showToast("NOTHING");
	}
	
	public void initializeDrmPlayer(final String videoUrl, final String subtitleUrl) {
		Uri subtitleUri = Uri.parse(subtitleUrl);
		
		MediaItem.SubtitleConfiguration subtitleConfiguration = new MediaItem.SubtitleConfiguration.Builder(subtitleUri)
		.setMimeType(MimeTypes.APPLICATION_SUBRIP)
		.setLanguage("English")
		.setSelectionFlags(C.SELECTION_FLAG_DEFAULT)
		.build();
		List<MediaItem.SubtitleConfiguration> subtitleConfigurations = new ArrayList<>();
		subtitleConfigurations.add(subtitleConfiguration);
		
		Uri videoUri = Uri.parse(videoUrl);
		MediaItem mediaItem = new MediaItem.Builder()
		.setUri(videoUri)
		.setSubtitleConfigurations(subtitleConfigurations)
		.build();
		
		exoPlayer.setMediaItem(mediaItem);
		exoPlayer.prepare();
		exoPlayer.play();
	}
	
	public void initializePlayerWithLicense(final String videoUrl, final String licenseUrl, final String drmScheme) {
    Uri mediaUri = Uri.parse(videoUrl);
    
    DefaultDataSource.Factory dataSourceFactory = createDataSourceFactory();
    
    UUID drmSchemeUuid = getDrmSchemeUuid(drmScheme);
    
    MediaItem.DrmConfiguration drmConfiguration = new MediaItem.DrmConfiguration.Builder(drmSchemeUuid)
    .setLicenseUri(licenseUrl)
    .build();
    
    MediaItem mediaItem = new MediaItem.Builder()
    .setUri(mediaUri)
    .setDrmConfiguration(drmConfiguration)
    .build();
    
    MediaSource mediaSource = createMediaSource(mediaItem, dataSourceFactory);
    
    // **[FIX 1: Player Creation Added]**
    exoPlayer = new ExoPlayer.Builder(context, renderersFactory) 
    .setTrackSelector(trackSelector)
    .setSeekForwardIncrementMs(10000L)
    .setSeekBackIncrementMs(10000L)
    .build();
    exoPlayer.setTrackSelectionParameters(trackSelectionParameters);
    
    final MediaSource sourceToLoad = mediaSource;

    // **[FIX 2: Delayed Attachment & Loading (100ms)]**
    AndroidUtilities.runOnUIThread(() -> {
        if (exoPlayer != null && playerView != null) {
            playerView.setPlayer(exoPlayer); 
            
            exoPlayer.setMediaSource(sourceToLoad);
            exoPlayer.prepare();
            exoPlayer.play();
        }
    }, 0); // Delay 100ms untuk stabilitas UI
}

    
    // Media3Helper.java
public void initializePlayerWithClearKey(final String videoUri, final String clearKey, final String drmScheme) {
    if (!clearKey.contains(":") || clearKey.contains("http://") || clearKey.contains("https://")) {
        return;
    }
    
    String uriVideo = videoUri;
    if (videoUri.contains("|")) {
        String[] parts = videoUri.split("\\|");
        uriVideo = parts[0];
    }
    
    String[] keyParts = clearKey.split(":");
    String clearKeyId = keyParts[0];
    String clearKeyVal = keyParts[1];
    
    byte[] drmKeyBytes = hexStringToByteArray(clearKeyVal);
    String encodedDrmKey = Base64.encodeToString(drmKeyBytes, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
    
    byte[] drmKeyIdBytes = hexStringToByteArray(clearKeyId);
    String encodedDrmKeyId = Base64.encodeToString(drmKeyIdBytes, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
    
    String drmBody = "{\"keys\":[{\"kty\":\"oct\",\"k\":\"" + encodedDrmKey + "\",\"kid\":\"" + encodedDrmKeyId + "\"}],\"type\":\"temporary\"}";
    
    final MediaItem dashMediaItem = new MediaItem.Builder() // Harus final agar bisa diakses di Runnable
    .setUri(uriVideo)
    .setMimeType(MimeTypes.APPLICATION_MPD)
    .build();
    
    LocalMediaDrmCallback drmCallback = new LocalMediaDrmCallback(drmBody.getBytes());
    DefaultDrmSessionManager drmSessionManager = new DefaultDrmSessionManager.Builder()
    .setPlayClearSamplesWithoutKeys(true)
    .setMultiSession(false)
    .setKeyRequestParameters(new HashMap<>())
    .setUuidAndExoMediaDrmProvider(C.CLEARKEY_UUID, FrameworkMediaDrm.DEFAULT_PROVIDER)
    .build(drmCallback);
    
    DefaultDataSource.Factory dataSourceFactory = createDataSourceFactory();
    
    DefaultMediaSourceFactory mediaSourceFactory = new DefaultMediaSourceFactory(dataSourceFactory)
    .setDrmSessionManagerProvider(mediaItem -> drmSessionManager);
    
    // Player Creation (Tidak bergantung pada UI, jadi aman di sini)
    exoPlayer = new ExoPlayer.Builder(context, renderersFactory)
    .setTrackSelector(trackSelector)
    .setMediaSourceFactory(mediaSourceFactory)
    .setSeekForwardIncrementMs(10000L)
    .setSeekBackIncrementMs(10000L)
    .build();
    exoPlayer.setTrackSelectionParameters(trackSelectionParameters);
    
    // **[Perbaikan Kritis] Delay Attachment ke View**
    // HAPUS blok playerView.post(...)
// GANTI DENGAN:

// **[FIX 3: Menggunakan Delay Waktu yang Stabil]**
final MediaItem mediaItemToLoad = dashMediaItem; // Gunakan final copy

AndroidUtilities.runOnUIThread(() -> {
    if (exoPlayer != null && playerView != null) {
        playerView.setPlayer(exoPlayer); 
        exoPlayer.setMediaItem(mediaItemToLoad);
        exoPlayer.prepare();
        exoPlayer.play();
    }
  }, 0); // Delay 100ms
 }
 
 

	
	private UUID getDrmSchemeUuid(String drmScheme) {
		switch (drmScheme.toLowerCase()) {
			case "widevine":
			return C.WIDEVINE_UUID;
			case "playready":
			return C.PLAYREADY_UUID;
			case "clearkey":
			return C.CLEARKEY_UUID;
			default:
			return C.WIDEVINE_UUID;
		}
	}
	
	private DefaultDataSource.Factory createDataSourceFactory() {
		// Buat HttpDataSource.Factory untuk HTTP/HTTPS request
		DefaultHttpDataSource.Factory httpDataSourceFactory = new DefaultHttpDataSource.Factory()
		.setUserAgent(userAgent != null ? userAgent : "DefaultUserAgent")
		.setDefaultRequestProperties(buildHttpHeaders());
		
		// Bungkus HttpDataSource.Factory ke dalam DefaultDataSource.Factory
		return new DefaultDataSource.Factory(
		context, // Context
		httpDataSourceFactory // Data source untuk koneksi HTTP
		);
	}
	
	private Map<String, String> buildHttpHeaders() {
		Map<String, String> requestProperties = new HashMap<>();
		if (cookie != null) {
			requestProperties.put("Cookie", cookie);
		}
		if (referer != null) {
			requestProperties.put("Referer", referer);
		}
		if (origin != null) {
			requestProperties.put("Origin", origin);
		}
		return requestProperties;
	}
	
	public String getUriMimeType(Uri uri) {
		@C.ContentType int type = Util.inferContentType(uri);
		switch (type) {
			case C.TYPE_DASH:
			return MimeTypes.APPLICATION_MPD;
			case C.TYPE_HLS:
			return MimeTypes.APPLICATION_M3U8;
			case C.TYPE_SS:
			return MimeTypes.VIDEO_UNKNOWN;
			case C.TYPE_OTHER:
			return MimeTypes.VIDEO_UNKNOWN;
			default:
			throw new IllegalArgumentException("Unsupported URI type: " + uri);
		}
	}
	
	private MediaSource createMediaSource(MediaItem mediaItem, DefaultDataSource.Factory dataSourceFactory) {
		@C.ContentType int type = detectContentType(mediaItem.buildUpon().build().localConfiguration.uri);
		switch (type) {
			case C.TYPE_DASH:
			return new DashMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem);
			case C.TYPE_HLS:
			return new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem);
			case C.TYPE_SS:
			return new SsMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem);
			case C.TYPE_OTHER:
			return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(mediaItem);
			default:
			AndroidUtilities.showToast("Unsupported type: " + type);
			throw new IllegalArgumentException("createMediaSource Unsupported type: " + type);
		}
	}
	
	private MediaSource createMediaSource(Uri uri, DefaultHttpDataSource.Factory dataSourceFactory) {
		@C.ContentType int type = Util.inferContentType(uri);
		switch (type) {
			case C.TYPE_DASH:
			return new DashMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
			case C.TYPE_HLS:
			return new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
			case C.TYPE_SS:
			return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
			case C.TYPE_OTHER:
			return new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
			default:
			throw new IllegalArgumentException("Unsupported type: " + type);
		}
	}
	
	private void showTrackSelection() {
		if (trackSelectionHelper != null) {
			trackSelectionHelper.showTrackSelection();
		}
	}
	
	protected void onStart() {
		
	}
	
	public void finish() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInPictureInPictureModeCompat()) {
			return;
		}
		((Activity)context).overridePendingTransition(R.anim.alpha_in, R.anim.alpha_out);
	}
	
	protected void onPause() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInPictureInPictureModeCompat()) {
			return;
		}
		if (exoPlayer != null) {
			exoPlayer.pause();
		}
	}
	
	protected void onResume() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && isInPictureInPictureModeCompat()) {
			return;
		}
		if (exoPlayer != null) {
			exoPlayer.setPlayWhenReady(true);
			exoPlayer.play();
		}
	}
	
	protected void onStop() {
		if (exoPlayer != null) {
			exoPlayer.stop();
		}
	}
	
	protected void onDestroy() {
		releasePlayer();
	}
	
	public void releasePlayer() {
		if (exoPlayer != null) {
			keepScreen(false);
			exoPlayer.release();
			exoPlayer = null;
		}
	}
    
    private byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
	
	private int detectContentType(Uri uri) {
		return detectContentType(uri.toString());
	}
	
	private int detectContentType(String url) {
		int type = Util.inferContentType(url);
		return type;
		}
        
        // Tambahkan di dalam kelas Media3Helper.java
        
        
    // Field yang sudah ada...
    
    // === TAMBAHKAN FIELD INI ===

    
 
 
 
 
 
  
    
    


public PlayerView getPlayerView() {
    return playerView;
}
  
   }
   
   
