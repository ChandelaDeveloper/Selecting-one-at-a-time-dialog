package machin.example.com.easyselection;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


public class SelectionAdapter extends RecyclerView.Adapter<SelectionAdapter.View_Holder> {


    private final Activity context;
    private final SetSelection callback;
    private List<String> experiencesList;
    private int selectedPosition = -1;
    private boolean isBold;
    private Typeface typeFace;
    private int color = -1;
    private Drawable backDrawable;


    public SelectionAdapter(List experiences, Activity context, SetSelection callback) {
        this.experiencesList = experiences;
        this.context = context;
        this.callback = callback;


    }

    @Override
    public View_Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = context.getLayoutInflater().inflate(R.layout.selection_adapter, parent, false);
        View_Holder view_holder = new View_Holder(view);
        return view_holder;
    }


    @Override
    public void onBindViewHolder(final View_Holder holder, final int position) {
        holder.txtName.setText(experiencesList.get(position));

        if (isBold)
            holder.txtName.setTypeface(null, Typeface.BOLD);

        if (typeFace != null)
            holder.txtName.setTypeface(typeFace, Typeface.BOLD);

        if (selectedPosition == position)
            holder.llItems.setSelected(true);
        else
            holder.llItems.setSelected(false);
        if (color != -1)
            holder.txtName.setTextColor(color);

        if (backDrawable != null)
            holder.llItems.setBackground(backDrawable);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedPosition = position;
                callback.selectedItem(position);
                notifyDataSetChanged();


            }
        });


    }

    @Override
    public int getItemCount() {
        return experiencesList != null ? experiencesList.size() : 0;
    }

    public void setTextBold(boolean adapter) {
        this.isBold = adapter;
    }

    public void setTextTypeFace(Typeface applyFont) {

        if (applyFont != null) {
            this.typeFace = applyFont;

        }
    }

    public void setTextColor(int color) {
        this.color = color;
    }

    public void setSelectorBackground(int drawable) {
        backDrawable = context.getResources().getDrawable(drawable);
//        backDrawable.mutate();

    }

    public interface SetSelection {
        void selectedItem(int position);
    }

    class View_Holder extends RecyclerView.ViewHolder {
        TextView txtName;
        LinearLayout llItems;

        public View_Holder(View itemView) {
            super(itemView);
            llItems = itemView.findViewById(R.id.llItems);
            txtName = itemView.findViewById(R.id.title);
        }
    }
}


