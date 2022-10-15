package com.example.lab_lb.l6;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lab_lb.R;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;


public class Lab63 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab63);


        LinearLayout dataLayout = findViewById(R.id.L4DataLayout);

        Handler.Callback hc = new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message message) {
                Bundle data = message.getData();
                String name = data.getString("name");
                String value = data.getString("value");
                dataLayout.addView(createView(name, value));
                return true;
            }
        };
        Handler handler = new Handler(hc);

        OkHttpClient client = new OkHttpClient();
        String url = "http://www.cbr.ru/scripts/XML_daily.asp";
        Request request = new Request.Builder()
                .url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                ResponseBody body = response.body();
                String bodyString = body.string();


                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                try {
                    DocumentBuilder builder = factory.newDocumentBuilder();
                    InputSource is = new InputSource(new StringReader(bodyString));
                    Document document = builder.parse(is);

                    NodeList valuteList = document.getDocumentElement().getElementsByTagName("Valute");

                    for (int i = 0; i < valuteList.getLength(); i++) {
                        Node valute = valuteList.item(i);
                        NodeList values = valute.getChildNodes();
                        Node name = values.item(3).getFirstChild();
                        Node value = values.item(4).getFirstChild();

                        Message msg = new Message();
                        Bundle data = new Bundle();
                        data.putString("name", name.getTextContent());
                        data.putString("value", value.getTextContent());
                        msg.setData(data);
                        handler.sendMessage(msg);

                    }

                } catch (ParserConfigurationException | SAXException e) {
                    Log.d("MEOW", e.toString());
                }
            }
        });
    }
    private View createView(String name, String value) {
        LinearLayout l = new LinearLayout(getApplicationContext());
        l.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 100);
        lp.setMargins(0, 0, 0, 20);
        l.setLayoutParams(lp);

        TextView nameView = new TextView(getApplicationContext());
        nameView.setText(name);

        TextView valueView = new TextView(getApplicationContext());
        valueView.setText(value);

        l.addView(nameView);
        l.addView(valueView);
        return l;
    }
}
