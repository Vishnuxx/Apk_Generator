package com.apk.builder;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import android.widget.LinearLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.ScrollView;
import android.widget.TextView;
import com.google.android.material.textfield.*;
import com.google.android.material.card.*;
import com.google.android.material.button.*;
import androidx.recyclerview.widget.*;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.widget.ImageView;
import android.app.Activity;
import android.content.SharedPreferences;
import android.widget.CompoundButton;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;
import android.content.Context;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import java.net.URISyntaxException;
import java.net.URI;
import java.io.File;
import androidx.appcompat.app.AlertDialog;
import com.tyron.compiler.CompilerAsyncTask;
import com.apk.builder.FileUtil;
import com.apk.builder.logger.*;
import com.apk.builder.model.Project;
import com.apk.builder.model.Library;
import com.apk.builder.model.ProjectSettings;
import com.apk.builder.util.JDKInstallTask;
import com.apk.builder.util.KotlinInstallTask;
import org.apache.commons.compress.compressors.xz.*;
import org.apache.commons.compress.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.archivers.tar.TarArchiveEntry;




import android.R;public class MainActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private ScrollView scroll;
	private LinearLayout base;
	private TextView projectSettings;
	private TextInputLayout res;
	private TextInputLayout java;
	private TextInputLayout manifest;
	private TextInputLayout assets;
	private TextInputLayout nativeLibs;
	private TextInputLayout til_output;
	private TextView librarySettingsText;
	private SwitchMaterial appcompat;
	private SwitchMaterial material;
	private TextInputLayout localLibs;
	private TextView buildSettings;
	private LinearLayout sdkBase;
	private TextView javaText;
	private RadioGroup javaGroup;
	private TextView dexerText;
	private RadioGroup dexer;
	private SwitchMaterial stringFog;
	private SwitchMaterial r8;
	private SwitchMaterial proguard;
	private TextInputLayout proguardRules;
	private SwitchMaterial kotlin_switch;
	private LinearLayout linear1;
	private TextView txt_output;
	private MaterialCardView cardview1;
	private MaterialButton run;
	private TextInputEditText resPath;
	private TextInputEditText javaPath;
	private TextInputEditText manifestPath;
	private TextInputEditText assetsPath;
	private TextInputEditText nativeLibsPath;
	private TextInputEditText et_output;
	private TextInputEditText localLibsPath;
	private TextInputLayout minSdk;
	private TextInputLayout maxSdk;
	private TextInputEditText minSdkValue;
	private TextInputEditText maxSdkValue;
	private MaterialRadioButton java6;
	private MaterialRadioButton java7;
	private MaterialRadioButton java8;
	private MaterialRadioButton dx;
	private MaterialRadioButton d8;
	private TextInputEditText proguardRulesPath;
	private MaterialButton linear2;
	private MaterialButton install_kotlin;
	private RecyclerView recyclerview1;
	private LinearLayout _drawer_base;
	private LinearLayout _drawer_banner;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear4;
	private ImageView _drawer_imageview1;
	private TextView _drawer_textview1;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview2;
	private ImageView _drawer_imageview3;
	private TextView _drawer_textview3;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview4;
	
	private SharedPreferences pref;
    
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		} else {
			initializeLogic();
		}
	}
	
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(MainActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		scroll = findViewById(R.id.scroll);
		base = findViewById(R.id.base);
		projectSettings = findViewById(R.id.projectSettings);
		res = findViewById(R.id.res);
		java = findViewById(R.id.java);
		manifest = findViewById(R.id.manifest);
		assets = findViewById(R.id.assets);
		nativeLibs = findViewById(R.id.nativeLibs);
		til_output = findViewById(R.id.til_output);
		librarySettingsText = findViewById(R.id.librarySettingsText);
		appcompat = findViewById(R.id.appcompat);
		material = findViewById(R.id.material);
		localLibs = findViewById(R.id.localLibs);
		buildSettings = findViewById(R.id.buildSettings);
		sdkBase = findViewById(R.id.sdkBase);
		javaText = findViewById(R.id.javaText);
		javaGroup = findViewById(R.id.javaGroup);
		dexerText = findViewById(R.id.dexerText);
		dexer = findViewById(R.id.dexer);
		stringFog = findViewById(R.id.stringFog);
		r8 = findViewById(R.id.r8);
		proguard = findViewById(R.id.proguard);
		proguardRules = findViewById(R.id.proguardRules);
		kotlin_switch = findViewById(R.id.kotlin_switch);
		linear1 = findViewById(R.id.linear1);
		txt_output = findViewById(R.id.txt_output);
		cardview1 = findViewById(R.id.cardview1);
		run = findViewById(R.id.run);
		resPath = findViewById(R.id.resPath);
		javaPath = findViewById(R.id.javaPath);
		manifestPath = findViewById(R.id.manifestPath);
		assetsPath = findViewById(R.id.assetsPath);
		nativeLibsPath = findViewById(R.id.nativeLibsPath);
		et_output = findViewById(R.id.et_output);
		localLibsPath = findViewById(R.id.localLibsPath);
		minSdk = findViewById(R.id.minSdk);
		maxSdk = findViewById(R.id.maxSdk);
		minSdkValue = findViewById(R.id.minSdkValue);
		maxSdkValue = findViewById(R.id.maxSdkValue);
		java6 = findViewById(R.id.java6);
		java7 = findViewById(R.id.java7);
		java8 = findViewById(R.id.java8);
		dx = findViewById(R.id.dx);
		d8 = findViewById(R.id.d8);
		proguardRulesPath = findViewById(R.id.proguardRulesPath);
		linear2 = findViewById(R.id.linear2);
		install_kotlin = findViewById(R.id.install_kotlin);
		recyclerview1 = findViewById(R.id.recyclerview1);
		_drawer_base = _nav_view.findViewById(R.id.base);
		_drawer_banner = _nav_view.findViewById(R.id.banner);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_imageview3 = _nav_view.findViewById(R.id.imageview3);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		pref = getSharedPreferences("config", Activity.MODE_PRIVATE);
		
		material.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					if (!appcompat.isChecked()) {
						appcompat.setChecked(true);
					}
				}
			}
		});
		
		proguard.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					proguardRules.setVisibility(View.VISIBLE);
				}
				else {
					proguardRules.setVisibility(View.GONE);
				}
			}
		});
		
		kotlin_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					linear1.setVisibility(View.VISIBLE);
				}
				else {
					linear1.setVisibility(View.GONE);
				}
			}
		});
		
		run.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SystemLogPrinter.start(mLogger);
				
				Project project = new Project();
				project.setLibraries(Library.fromFile(new File(localLibsPath.getText().toString())));
				
				project.setResourcesFile(new File(resPath.getText().toString()));
				
				project.setOutputFile(new File(et_output.getText().toString()));
				
				project.setJavaFile(new File(javaPath.getText().toString()));
				
				project.setManifestFile(new File(manifestPath.getText().toString()));
				project.setProjectSettings(new ProjectSettings());
				if (!android.text.TextUtils.isEmpty(assetsPath.getText().toString())) {
					    project.setAssetsFile(new File(assetsPath.getText().toString()));
				}
				project.setNativeLibraries(new File(nativeLibsPath.getText().toString()));
				project.setLogger(mLogger);
				project.setMinSdk(Integer.parseInt(minSdkValue.getText().toString()));
				project.setTargetSdk(Integer.parseInt(maxSdkValue.getText().toString()));
				CompilerAsyncTask task = new CompilerAsyncTask(MainActivity.this);
				
				task.execute(project);
			}
		});
		
		linear2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
				    chooseFile.setType("*/*");
				    chooseFile = Intent.createChooser(chooseFile, "Choose a file");
				    startActivityForResult(chooseFile, 20);
			}
		});
		
		install_kotlin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
				    chooseFile.setType("*/*");
				    chooseFile = Intent.createChooser(chooseFile, "Choose a file");
				    startActivityForResult(chooseFile, 21);
			}
		});
	}
	
	private void initializeLogic() {
		
		proguardRules.setVisibility(View.GONE);
		minSdkValue.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "30")});
		maxSdkValue.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "30")});
		res.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 0);
				}
				    }
		});
		java.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 1);
				}
				    }
		});
		manifest.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
					    chooseFile.setType("text/xml");
					    chooseFile = Intent.createChooser(chooseFile, "Choose a file");
					    startActivityForResult(chooseFile, 2);
				}
				    }
		});
		assets.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 3);
				}
				    }
		});
		nativeLibs.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 4);
				}
				    }
		});
		localLibs.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 5);
				}
				    }
		});
		til_output.setEndIconOnClickListener(new View.OnClickListener() {
			    @Override
			    public void onClick(View v) {
				if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){ 
					    Intent i = new Intent(Intent.ACTION_OPEN_DOCUMENT_TREE); 
					    i.addCategory(Intent.CATEGORY_DEFAULT);
					    startActivityForResult(Intent.createChooser(i, "Choose directory"), 6);
				}
				    }
		});
		
		mLogger = new Logger();
		mLogger.attach(recyclerview1);
		
		resPath.setText(pref.getString("resPath", ""));
		javaPath.setText(pref.getString("javaPath", ""));
		manifestPath.setText(pref.getString("manifestPath", ""));
		et_output.setText(pref.getString("outputPath", ""));
		localLibsPath.setText(pref.getString("libPath", ""));
		assetsPath.setText(pref.getString("assetsPath", ""));
	}
	private Logger mLogger;
	{
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		pref.edit().putString("resPath", resPath.getText().toString()).commit();
		pref.edit().putString("javaPath", javaPath.getText().toString()).commit();
		pref.edit().putString("manifestPath", manifestPath.getText().toString()).commit();
		pref.edit().putString("outputPath", et_output.getText().toString()).commit();
		pref.edit().putString("libPath", localLibsPath.getText().toString()).commit();
		pref.edit().putString("assetsPath", assetsPath.getText().toString()).commit();
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			super.onBackPressed();
		}
	}
}
