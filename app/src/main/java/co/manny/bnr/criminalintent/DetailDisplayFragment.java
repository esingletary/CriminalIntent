package co.manny.bnr.criminalintent;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by Emmanuel on 12/8/2017.
 */

public class DetailDisplayFragment extends DialogFragment {

    private ImageView mDetailView;

    private static final String ARG_CRIME = "crime";

    public static DetailDisplayFragment newInstance(File photoFile) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME, photoFile);

        DetailDisplayFragment fragment = new DetailDisplayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        File photoFile = (File) getArguments().getSerializable(ARG_CRIME);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_detail, null);

        mDetailView = (ImageView) v.findViewById(R.id.detail_view);

        if (photoFile == null || !photoFile.exists()) {
            mDetailView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(photoFile.getPath(), getActivity());
            mDetailView.setImageBitmap(bitmap);
        }

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setMessage("Image detail")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {

                    }
                }).create();
    }

}
