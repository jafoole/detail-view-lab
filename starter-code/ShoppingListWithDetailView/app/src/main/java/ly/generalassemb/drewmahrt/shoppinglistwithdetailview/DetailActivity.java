package ly.generalassemb.drewmahrt.shoppinglistwithdetailview;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    ShoppingSQLiteOpenHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        mHelper = new ShoppingSQLiteOpenHelper(DetailActivity.this);
        Cursor cursor = mHelper.getShoppingList();

        TextView nameTextView = (TextView)findViewById(R.id.textViewName);
        TextView descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
        TextView priceTextView = (TextView)findViewById(R.id.priceTextView);
        TextView typeTextView = (TextView)findViewById(R.id.typeTextView);


        int id = getIntent().getIntExtra("id", -1);

        if (id > 0 ){

            String item_name = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getItemName(id);
            String description = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getDescriptionId(id);
            String price = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getPriceName(id);
            String type = ShoppingSQLiteOpenHelper.getInstance(DetailActivity.this).getTypeName(id);


            nameTextView.setText(item_name);
            descriptionTextView.setText(description);
            priceTextView.setText(price);
            typeTextView.setText(type);
        }

    }
}