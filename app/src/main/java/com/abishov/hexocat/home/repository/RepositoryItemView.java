package com.abishov.hexocat.home.repository;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.abishov.hexocat.R;
import com.abishov.hexocat.common.picasso.PicassoServiceLocator;
import com.abishov.hexocat.common.views.Truss;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import butterknife.BindView;
import butterknife.ButterKnife;

public final class RepositoryItemView extends RelativeLayout {

    @BindView(R.id.imageview_owner_logo)
    ImageView imageViewLogo;

    @BindView(R.id.textview_repository_name)
    TextView textViewRepositoryName;

    @BindView(R.id.textview_repository_description)
    TextView textViewRepositoryDescription;

    @BindView(R.id.textview_repository_forks)
    TextView textViewForks;

    @BindView(R.id.textview_repository_stars)
    TextView textViewStars;

    private Picasso picasso;
    private Transformation transformation;

    private final int descriptionColor;

    public RepositoryItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedValue outValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.textColorSecondary,
                outValue, true);
        descriptionColor = ContextCompat.getColor(
                context, outValue.resourceId);

        if (!isInEditMode()) {
            picasso = PicassoServiceLocator.obtain(context);
            transformation = PicassoServiceLocator.obtainTransformation(context);
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }

    public void bindTo(RepositoryViewModel repository) {
        picasso.load(repository.avatarUrl())
                .placeholder(R.drawable.avatar)
                .fit()
                .transform(transformation)
                .into(imageViewLogo);

        textViewRepositoryName.setText(repository.name());
        textViewForks.setText(repository.forks());
        textViewStars.setText(repository.stars());

        Truss description = new Truss();
        description.append(repository.login());

        if (!TextUtils.isEmpty(repository.description())) {
            description.pushSpan(new ForegroundColorSpan(descriptionColor));
            description.append(" — ");
            description.append(repository.description());
            description.popSpan();
        }

        textViewRepositoryDescription.setText(description.build());
    }
}
