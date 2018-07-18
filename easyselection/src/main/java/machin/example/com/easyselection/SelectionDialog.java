package machin.example.com.easyselection;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Typeface;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;


public class SelectionDialog implements SelectionAdapter.SetSelection {

    private static final String LOG_ERROR = "selection_ERROR";
    private Dialog dialog;
    private TextView title_lbl;
    private SelectionListener selectionListener;
    private boolean negativeExist;
    private RecyclerView mRecyclerView;
    private GridLayoutManager mLayoutManager;
    private List<String> list;
    private Activity activity;

    public SelectionDialog(Activity context, String title, int color, Typeface typeFace, boolean cancelable) {
        negativeExist = false;
        this.activity = context;
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.selectiondialog_layout);

      /*  if (dialog.getWindow() != null)
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));*/
        Window window = dialog.getWindow();
        window.setLayout(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        window.setGravity(Gravity.CENTER);
        initViews();
        // use a linear layout manager
        mLayoutManager = new GridLayoutManager(context, 5);
        mRecyclerView.setLayoutManager(mLayoutManager);

        dialog.setCancelable(cancelable);
        setTitle(title);
        setTitleColor(color);
        setTypefaces(typeFace);


    }

    void setList(List data) {
        this.list = data;
    }

    void setSelectionListener(SelectionListener listener, boolean showDataBold, Typeface fontShow, int color, int drawable) {
        if (listener != null) {
            this.selectionListener = listener;
            this.dismiss();
        }
        setAdapter(showDataBold, fontShow, color, drawable);
    }


    private void setAdapter(boolean adapterBold, Typeface typeFace, int color, int drawable) {
        SelectionAdapter selectionAdapter = new SelectionAdapter(list, activity, this);
        selectionAdapter.setTextBold(adapterBold);
        selectionAdapter.setTextColor(color);
        if (drawable != 0&&drawable!=-1)
            selectionAdapter.setSelectorBackground(drawable);
        selectionAdapter.setTextTypeFace(typeFace);
        mRecyclerView.setAdapter(selectionAdapter);


    }

    public void show() {

        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

    void setTitle(String title) {
        title_lbl.setVisibility(View.VISIBLE);
        title_lbl.setText(title);
    }

    void setTitleColor(int color) {
        if (color != -1)
            title_lbl.setTextColor(color);
    }


    private void setTypefaces(Typeface applyFont) {
        if (applyFont != null) {
            title_lbl.setTypeface(applyFont);

        }
    }


    private void initViews() {
        title_lbl = dialog.findViewById(R.id.title);
        mRecyclerView = (RecyclerView) dialog.findViewById(R.id.my_recycler_view);

    }


    @Override
    public void selectedItem(int position) {
        selectionListener.onClick(SelectionDialog.this, position);
    }
}


