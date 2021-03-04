package com.demo.api_demo.activity;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.DefaultItemAnimator;
        import androidx.recyclerview.widget.DividerItemDecoration;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.AbsListView;
        import android.widget.ProgressBar;

        import com.demo.api_demo.DataAdapter.MDataAdapter;
        import com.demo.api_demo.DataAdapter.MessageDataAdapter;
        import com.demo.api_demo.Model.MResponse;
        import com.demo.api_demo.Model.MessageResponse;
        import com.demo.api_demo.R;
        import com.demo.api_demo.rest.ApiClient;
        import com.demo.api_demo.rest.ApiInterface;

        import java.util.ArrayList;
        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<MessageResponse> messageDataList = new ArrayList<MessageResponse>();
    private List<MResponse> commentList = new ArrayList<MResponse>();
    Boolean isScrolling = false;
    int currentItems,totalItems,scrollOutItems;
    GridLayoutManager manager;
    ProgressBar progressBar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //progressBar = (ProgressBar) findViewById(R.id.progressBar);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView3);
        manager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        //recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
       // prepareMessageDetails();

        //jo sauthi pehla apde api ne attach karvi pade apda project ma aaa file ni andar.
        //etle api kai file ma che?
        //type here file name
        //ApiClient ok great
        // And apde api ne ena end point jode attach krvanu
       ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
        // jo apde ApiClient.getClient() anathi api call kari nakhi then
        // je response ave che e messageresponse ma ave che so apde ene avi rite lakhsu
        // api interface no object banayo che so ena use thi apde end point ne call karisu

        // etle apde Call<ama list vado j parameter call krvo pdse
        // >

        Call<List<MessageResponse>> call=apiInterface.getMessageDetails();
        call.enqueue(new Callback<List<MessageResponse>>() {
            @Override
            public void onResponse(Call<List<MessageResponse>> call, Response<List<MessageResponse>> response) {
                // done thai gyu api call
                // je reponse aavse e ama avse nd in case koi api fail thay to
                if (response.isSuccessful()){
                    MessageDataAdapter adapter = new MessageDataAdapter(response.body());
                    recyclerView.setAdapter(adapter);
//have joie le tu koi na khbr padi hoy to msg krje
                    //ohk
                    //niche je data 6e ae rakhu k nikalu ?
                    // rakh pan recycler ma pass nai krvano etle tne clear khbr padi jase ke kai list send thay che nd kai nai
                    //ohk ane ahi recycler ma error aave 6e ae
                    // jate solve jvanu badhu hu kari apis to tu su sikhe
                    //ohk ohk aato just pu6yuok ok vn try it your self i m here
                }

            }

            @Override
            public void onFailure(Call<List<MessageResponse>> call, Throwable t) {
                //ani andar avse
            }
        });

       /* recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true;
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                currentItems = manager.getChildCount();
                totalItems = manager.getItemCount();
                scrollOutItems = manager.findFirstVisibleItemPosition();
                if (isScrolling && (currentItems + scrollOutItems == totalItems))
                {
                    isScrolling = false;
                    //getData();
                    prepareMessageDetails();
                }
            }
        });

*/

    }


    /*private void prepareMessageDetails() {
        MessageResponse messageData = new MessageResponse(1,"hello","qwertyuiop");
        messageDataList.add(messageData);
        messageData = new MessageResponse(2,"hello","qwertyuiop");
        messageDataList.add(messageData);
        messageData = new MessageResponse(3,"qwert","asdfghjkl");
        messageDataList.add(messageData);
        messageData = new MessageResponse(4,"asdfg","zxcvbnm");
        messageDataList.add(messageData);
        messageData = new MessageResponse(5,"qazxsw","polkijmnbhuygvft");
        messageDataList.add(messageData);
    }*/


/*private void getData(){

    ApiInterface apiInterface=ApiClient.getClient().create(ApiInterface.class);
    progressBar.setVisibility(View.VISIBLE);
    Call<List<MessageResponse>> call= apiInterface.getMessageDetails();
    call.enqueue(new Callback<List<MessageResponse>>() {
        @Override
        public void onResponse(Call<List<MessageResponse>> call, Response<List<MessageResponse>> response) {
            if (response.isSuccessful()){
                MessageDataAdapter adapter = new MessageDataAdapter(response.body());
                recyclerView.setAdapter(adapter);
            }

        }

        @Override
        public void onFailure(Call<List<MessageResponse>> call, Throwable t) {
        }
    });

}*/
}
