package com.stevenbyle.android.materialthemes.controller.home.material;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.stevenbyle.android.materialthemes.BuildConfig;
import com.stevenbyle.android.materialthemes.R;
import com.stevenbyle.android.materialthemes.controller.theme.MaterialTheme;
import com.stevenbyle.android.materialthemes.log.LogUtils;

/**
 * Simple dialog fragment that creates an alert dialog that can be themed.
 *
 * @author Steven Byle
 */
public class MaterialThemeAlertDialogFragment extends DialogFragment implements DialogInterface.OnClickListener {
    private static final String TAG = LogUtils.generateTag(MaterialThemeInXmlFragment.class);

    private static final String KEY_ARG_TITLE = "KEY_ARG_TITLE";
    private static final String KEY_ARG_MESSAGE = "KEY_ARG_MESSAGE";
    private static final String KEY_ARG_ALERT_DIALOG_THEME = "KEY_ARG_ALERT_DIALOG_THEME";

    private String mTitle, mMessage;
    private MaterialTheme mAlertDialogTheme;

    public static MaterialThemeAlertDialogFragment newInstance(Context context, @StringRes int titleResId,
            @StringRes int messageResId, @Nullable MaterialTheme alertDialogTheme) {

        MaterialThemeAlertDialogFragment fragment = newInstance(
                context.getString(titleResId),
                context.getString(messageResId),
                alertDialogTheme);
        return fragment;
    }

    public static MaterialThemeAlertDialogFragment newInstance(String title, String message,
            @Nullable MaterialTheme alertDialogTheme) {

        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "newInstance");
        }

        MaterialThemeAlertDialogFragment fragment = new MaterialThemeAlertDialogFragment();
        Bundle args = fragment.getArguments();
        if (args == null) {
            args = new Bundle();
        }

        args.putString(KEY_ARG_TITLE, title);
        args.putString(KEY_ARG_MESSAGE, message);
        args.putSerializable(KEY_ARG_ALERT_DIALOG_THEME, alertDialogTheme);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnAttach(TAG);
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreate(TAG, savedInstanceState);
        }

        // Get passed in parameters
        Bundle args = getArguments();

        // If no parameters were passed in, default them
        if (args == null) {
            mTitle = null;
            mMessage = null;
            mAlertDialogTheme = null;
        }
        // Otherwise, set incoming parameters
        else {
            mTitle = args.getString(KEY_ARG_TITLE);
            mMessage = args.getString(KEY_ARG_MESSAGE);
            mAlertDialogTheme = (MaterialTheme) args.getSerializable(KEY_ARG_ALERT_DIALOG_THEME);
        }

        // If this is the first creation, default state variables
        if (savedInstanceState == null) {
        }
        // Otherwise, restore state
        else {
        }

    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreateDialog(TAG, savedInstanceState);
        }

        // Create the alert dialog using the proper theme
        Activity parentActivity = getActivity();
        AlertDialog.Builder alertDialogBuilder;
        if (mAlertDialogTheme != null) {
            alertDialogBuilder = new AlertDialog.Builder(parentActivity, mAlertDialogTheme.getThemeResId());
        }
        else {
            alertDialogBuilder = new AlertDialog.Builder(parentActivity);
        }

        alertDialogBuilder.setTitle(mTitle)
                .setMessage(mMessage)
                .setPositiveButton(R.string.material_theme_dialog_button_positive, this)
                .setNegativeButton(R.string.material_theme_dialog_button_negative, this);

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        return alertDialog;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (BuildConfig.DEBUG) {
            LogUtils.logOnCreateView(TAG, savedInstanceState);
        }

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnViewCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnActivityCreated(TAG, savedInstanceState);
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnViewStateRestored(TAG, savedInstanceState);
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnStart(TAG);
        }
    }

    @Override
    public void onResume() {
        super.onResume();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnResume(TAG);
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnPause(TAG);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        if (BuildConfig.DEBUG) {
            LogUtils.logOnSaveInstanceState(TAG);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnStop(TAG);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnDestroyView(TAG);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (BuildConfig.DEBUG) {
            LogUtils.logOnDestroy(TAG);
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);

        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onDismiss");
        }
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);

        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onCancel");
        }
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (BuildConfig.DEBUG) {
            LogUtils.logMethod(TAG, "onClick");
        }
    }

}