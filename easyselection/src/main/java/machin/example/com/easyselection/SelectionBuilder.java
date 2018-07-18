package machin.example.com.easyselection;

import android.app.Activity;
import android.graphics.Typeface;

import java.util.List;

public class SelectionBuilder {
    private Typeface tf;
    private boolean bold, cancelable;
    private String title;
    private Activity context;
    private SelectionListener selectionListener;
    private List<String> dataList;
    private int color=-1;
    private int dataColor=-1;
    private int drawable=-1;

    public SelectionBuilder(Activity context) {
        this.context = context;
    }

    public SelectionBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public SelectionBuilder setTitleColor(int color) {
        this.color = color;
        return this;
    }
// public SelectionBuilder setDrawableBackground(int drawable) {
//        this.drawable = drawable;
//        return this;
//    }

    public SelectionBuilder setList(List<String> dataList) {
        this.dataList = dataList;
        return this;
    }


    public SelectionBuilder setDataBold(boolean bold) {
        this.bold = bold;
        return this;
    }

    public SelectionBuilder setDataTextColor(int color) {
        this.dataColor = color;
        return this;
    }

    public SelectionBuilder setFont(Typeface font) {
        this.tf = font;
        return this;
    }

    public SelectionBuilder setCancelable(boolean cancelable) {
        this.cancelable = cancelable;
        return this;
    }

    public SelectionBuilder setCallBackListener(SelectionListener listener) {
        this.selectionListener = listener;
        return this;
    }


    public SelectionDialog build() {
        SelectionDialog dialog = new SelectionDialog(context, title,color, tf, cancelable);
        dialog.setList(dataList);
        dialog.setSelectionListener(selectionListener, bold, tf,dataColor,drawable);
        return dialog;
    }

}
