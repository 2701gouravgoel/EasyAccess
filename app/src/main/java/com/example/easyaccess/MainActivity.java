package com.example.easyaccess;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    ImageButton fbOpen;
    ImageButton instaOpen;
    ImageButton codechefOpen;
    ImageButton codeforcsOpen;
    ImageButton phoneOpen1;
    ImageButton phoneOpen2;
    ImageButton phoneOpen3;
    ImageButton phoneOpen4;
    EditText yourSong;
    Button listenYoutube;
    Button listenOffline;
    EditText YourSearch;
    Button Googlehere;
    ImageButton playVideo;
    ImageButton openImages;
    private MediaPlayer mediaPlayer;
    private ImageButton playTune1;
    private ImageButton playTune2;
    private ImageButton playTune3;
    private ImageButton playTune4;
    private ImageButton playTune5;
    private ImageButton play;
    private ImageButton pause;
    private ImageButton Mike;
    private ListView mList;
    private EditText et;
    private View v;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        InitializedFields();

        PackageManager pm = getPackageManager();
        List activities = pm.queryIntentActivities(new Intent(
                RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
        if (activities.size() != 0)
        {
                    StartVoiceRecognition();
                    Mike.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            StartVoiceRecognition();
                        }
                    });

        }
        else {
            Mike.setEnabled(false);
        }


        playTune1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.bebe);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        playTune2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();

                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.brokenangle);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        playTune3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {


                    mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.darker);

                    mediaPlayer.setLooping(true);
                    mediaPlayer.start();
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            Toast.makeText(MainActivity.this, "The song is over", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                catch (IllegalStateException e)
                {
                        e.printStackTrace();
                }
            }
        });
        playTune4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.excuse);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        playTune5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.pirates);
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                mediaPlayer.release();
            }
        });



        phoneOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent CallIntent = new Intent(Intent.ACTION_CALL);
                CallIntent.setData(Uri.parse("tel:91-9255406419"));
            }
        });
        phoneOpen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeCall(2);
            }
        });
        phoneOpen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeCall(3);
            }
        });
        phoneOpen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MakeCallViaNo(1);
            }
        });

        fbOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.facebook.com");
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        instaOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.instagram.com");
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        codechefOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.codechef.com");
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        listenYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = yourSong.getText().toString();
                Uri uri = Uri.parse("http://www.youtube.com/results?search_query="+s);
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });



        Googlehere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = YourSearch.getText().toString();
                Uri uri = Uri.parse("http://www.google.com/search?channel=fs&q="+s+"&ie=utf-8&oe=utf-8");
                Intent i =new Intent(Intent.ACTION_VIEW,uri);
                startActivity(i);
            }
        });

        openImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivity(intent);
            }
        });

        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");
                startActivity(intent);
            }
        });


        listenOffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = yourSong.getText().toString();
                Intent i =new Intent(Intent.ACTION_PICK);
                i.setType("audio/"+s);
                startActivityForResult(i,1);

            }
        });



    }

    private void StartVoiceRecognition()
    {
        Intent intent= new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,"Speech recognition Demo");
        startActivityForResult(intent,2);
    }

    private void MakeCallViaNo(int i)
    {
        Intent myintent = new Intent((Intent.ACTION_DIAL));
        myintent.setData(Uri.parse("tel: "));
    }


    private void MakeCall(int i)
    {
        Intent CallIntent = new Intent(Intent.ACTION_CALL);
        if(i==1) {CallIntent.setData(Uri.parse("tel:91-9255406419"));}
        if(i==2) {CallIntent.setData(Uri.parse("91-9255406419"));}
        if(i==3) {CallIntent.setData(Uri.parse("91-9255406419"));}
    }

    private void InitializedFields()
    {
        fbOpen = (ImageButton)findViewById(R.id.fb_Open);
        phoneOpen1 = (ImageButton)findViewById(R.id.call1);
        phoneOpen2 = (ImageButton)findViewById(R.id.call2);
        phoneOpen3 = (ImageButton)findViewById(R.id.call3);
        phoneOpen4 = (ImageButton)findViewById(R.id.call4);
        instaOpen = (ImageButton)findViewById(R.id.insta_Open);
        codechefOpen = (ImageButton)findViewById(R.id.Codechef_Open);
        codeforcsOpen = (ImageButton)findViewById(R.id.codeforces_Open);
        yourSong = (EditText)findViewById(R.id.your_song);
        listenYoutube=(Button)findViewById(R.id.listen_youtube);
        listenOffline=(Button)findViewById(R.id.listen_music);
        YourSearch = (EditText)findViewById(R.id.your_search);
        Googlehere=(Button)findViewById(R.id.search_google);
        playVideo=(ImageButton)findViewById(R.id.play_video);
        openImages=(ImageButton)findViewById(R.id.play_images);
        playTune1=(ImageButton)findViewById(R.id.play_tune1);
        playTune3=(ImageButton)findViewById(R.id.play_tune3);
        playTune2=(ImageButton)findViewById(R.id.play_tune2);
        playTune4=(ImageButton)findViewById(R.id.play_tune4);
        playTune5=(ImageButton)findViewById(R.id.play_tune5);
        play=(ImageButton)findViewById(R.id.play_button);
        pause=(ImageButton)findViewById(R.id.pause_button);
        Mike=(ImageButton)findViewById(R.id.voice_mike);
        mList=(ListView)findViewById(R.id.list);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK)
        {
            if(requestCode==1)
            {
                Uri songUri = data.getData();
                mediaPlayer = MediaPlayer.create(MainActivity.this,songUri);

                mediaPlayer.setLooping(true);
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        Toast.makeText(MainActivity.this,"The song is over",Toast.LENGTH_SHORT).show();
                    }
                });
            }

            if(requestCode==2)
            {
                ArrayList<String> matches =data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                int r=0;
                String ss = "";
                for (String s: matches)
                {
                    s +=" ";
                    String sa="";
                    for(int i=0;i<s.length();i++)
                    {
                        if(s.charAt(i)-' '==0)
                        {
                            Toast.makeText(MainActivity.this,""+sa,Toast.LENGTH_SHORT).show();
                            if (sa.equals("play"))
                            {
                                Toast.makeText(MainActivity.this, "oye", Toast.LENGTH_SHORT).show();
                            } else if (sa.equals("YouTube") || sa.equals("youtube")) {
                                r = 1;
                            } else if (sa.equals("Facebook")) {

                                r = 2;
                                break;
                            } else if (sa.equals("Instagram")||sa.equals("instagram")) {
                                r = 3;break;
                            } else if (sa.equals("Codechef")||sa.equals("codechef")) {
                                r = 4;break;
                            } else if (sa.equals("Codeforces")||sa.equals("codeforces")) {
                                r = 5;break;
                            } else if (sa.equals("Images")||sa.equals("images")||sa.equals("image")||sa.equals("Image")) {
                                r = 6;break;
                            } else if (sa.equals("video")||sa.equals("videos")||sa.equals("Videos")||sa.equals("Video")) {
                                r = 7;break;
                            } else if (sa.equals("leave")||sa.equals("no")||sa.equals("No")) {
                                r = 8;break;
                            } else {
                                ss += sa + " ";
                            }

                            sa="";
                        }
                        else
                        {
                            sa+=s.charAt(i);
                        }
                    }
                }
                if(r==1)
                {

                    Uri uri = Uri.parse("http://www.youtube.com/results?search_query="+ss);
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }

                if(r==2)
                {

                    Uri uri = Uri.parse("http://www.facebook.com");
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
                if(r==3)
                {

                    Uri uri = Uri.parse("http://www.instagram.com");
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
                if(r==4)
                {

                    Uri uri = Uri.parse("http://www.codechef.com");
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
                if(r==5)
                {

                    Uri uri = Uri.parse("http://www.codeforces.com");
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
                if(r==6)
                {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("image/*");
                    startActivity(intent);
                }
                if(r==7)
                {
                    Intent intent = new Intent(Intent.ACTION_PICK);
                    intent.setType("video/*");
                    startActivity(intent);
                }
                if (r==8)
                {
                    Uri uri = Uri.parse("http://www.google.com/search?channel=fs&q="+ss+"&ie=utf-8&oe=utf-8");
                    Intent i =new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                }
            }


        }
    }
}
