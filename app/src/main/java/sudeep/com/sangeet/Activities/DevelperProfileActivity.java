package sudeep.com.sangeet.Activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import rohksin.com.olaplay.R;


public class DevelperProfileActivity extends AppCompatActivity {


    @BindView(R.id.linkedIn)
    CircleImageView linkedin;

    @BindView(R.id.github)
    CircleImageView github;

    @BindView(R.id.googlePlay)
    CircleImageView playstore;

    @BindView(R.id.gmail)
    CircleImageView gmail;

    @BindView(R.id.stackoerflow)
    CircleImageView stackoverflow;


    private String gitHubLink ="https://github.com/sudeepbhattarai100";
    private String gmailId ="sudeepbhattarai100@gmail.com";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dev_profile);
        ButterKnife.bind(this);




        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openLinkWithBrowser(gitHubLink);
            }
        });





        gmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 openGmail();
            }
        });
    }

    private void openLinkWithBrowser(String url){

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }

    private void openGmail(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                "mailto",gmailId, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Body");
        startActivity(Intent.createChooser(emailIntent, "Send email..."));
    }

}
