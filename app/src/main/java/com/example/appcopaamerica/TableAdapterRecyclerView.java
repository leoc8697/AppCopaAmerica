package com.example.appcopaamerica;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class TableAdapterRecyclerView extends RecyclerView.Adapter<TableAdapterRecyclerView.TableViewHolder> {

    private ArrayList<TableModel> tables;
    private int resource;
    private Activity activity;

    public TableAdapterRecyclerView(ArrayList<TableModel> tables, int resource, Activity activity) {
        this.tables = tables;
        this.resource = resource;
        this.activity = activity;
    }

    @Override
    public TableViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //El siguiente paso es inflar, que significa hacer uso de un layout dentro de otro layout.
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_position, parent,false);
        return new TableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TableViewHolder holder, int position) {
        TableModel table = tables.get(position);
        holder.nameGroup.setText(table.getNameGroup());
        //holder.infoGroup.setText(table.getInfoGroup());
        holder.position1.setText(table.getPosition1());
        holder.position2.setText(table.getPosition2());
        holder.position3.setText(table.getPosition3());
        holder.position4.setText(table.getPosition4());
        holder.namePosition1.setText(table.getNamePosition1());
        holder.namePosition2.setText(table.getNamePosition2());
        holder.namePosition3.setText(table.getNamePosition3());
        holder.namePosition4.setText(table.getNamePosition4());
        holder.pj1.setText(table.getPj1());
        holder.pj2.setText(table.getPj2());
        holder.pj3.setText(table.getPj3());
        holder.pj4.setText(table.getPj4());
        holder.goals1.setText(table.getGoals1());
        holder.goals2.setText(table.getGoals2());
        holder.goals3.setText(table.getGoals3());
        holder.goals4.setText(table.getGoals4());
        holder.difGoal1.setText(table.getDifGoal1());
        holder.difGoal2.setText(table.getDifGoal2());
        holder.difGoal3.setText(table.getDifGoal3());
        holder.difGoal4.setText(table.getDifGoal4());
        holder.pts1.setText(table.getPts1());
        holder.pts2.setText(table.getPts2());
        holder.pts3.setText(table.getPts3());
        holder.pts4.setText(table.getPts4());
        holder.imgPos1.setImageResource(table.getImgPos1());
        holder.imgPos2.setImageResource(table.getImgPos2());
        holder.imgPos3.setImageResource(table.getImgPos3());
        holder.imgPos4.setImageResource(table.getImgPos4());
    }

    @Override
    public int getItemCount() {
        return tables.size();
    }

    public class TableViewHolder extends RecyclerView.ViewHolder {

        private TextView nameGroup, position1, position2, position3, position4,
                namePosition1, namePosition2, namePosition3, namePosition4,
                pj1, pj2, pj3, pj4, goals1, goals2, goals3, goals4,
                difGoal1, difGoal2, difGoal3, difGoal4, pts1, pts2, pts3, pts4;
        private ImageView imgPos1, imgPos2, imgPos3, imgPos4;

        public TableViewHolder(View itemView){
            super(itemView);

            nameGroup     = (TextView)  itemView.findViewById(R.id.textGroup);
            //infoGroup     = (TextView)  itemView.findViewById(R.id.textInfoGroup);
            position1     = (TextView)  itemView.findViewById(R.id.textPos1);
            position2     = (TextView)  itemView.findViewById(R.id.textPos2);
            position3     = (TextView)  itemView.findViewById(R.id.textPos3);
            position4     = (TextView)  itemView.findViewById(R.id.textPos4);
            namePosition1 = (TextView)  itemView.findViewById(R.id.textNamePos1);
            namePosition2 = (TextView)  itemView.findViewById(R.id.textNamePos2);
            namePosition3 = (TextView)  itemView.findViewById(R.id.textNamePos3);
            namePosition4 = (TextView)  itemView.findViewById(R.id.textNamePos4);
            pj1           = (TextView)  itemView.findViewById(R.id.textPJ1);
            pj2           = (TextView)  itemView.findViewById(R.id.textPJ2);
            pj3           = (TextView)  itemView.findViewById(R.id.textPJ3);
            pj4           = (TextView)  itemView.findViewById(R.id.textPJ4);
            goals1        = (TextView)  itemView.findViewById(R.id.textGoles1);
            goals2        = (TextView)  itemView.findViewById(R.id.textGoles2);
            goals3        = (TextView)  itemView.findViewById(R.id.textGoles3);
            goals4        = (TextView)  itemView.findViewById(R.id.textGoles4);
            difGoal1      = (TextView)  itemView.findViewById(R.id.textDifGol1);
            difGoal2      = (TextView)  itemView.findViewById(R.id.textDifGol2);
            difGoal3      = (TextView)  itemView.findViewById(R.id.textDifGol3);
            difGoal4      = (TextView)  itemView.findViewById(R.id.textDifGol4);
            pts1          = (TextView)  itemView.findViewById(R.id.textPts1);
            pts2          = (TextView)  itemView.findViewById(R.id.textPts2);
            pts3          = (TextView)  itemView.findViewById(R.id.textPts3);
            pts4          = (TextView)  itemView.findViewById(R.id.textPts4);
            imgPos1       = (ImageView) itemView.findViewById(R.id.imgTeamPos1);
            imgPos2       = (ImageView) itemView.findViewById(R.id.imgTeamPos2);
            imgPos3       = (ImageView) itemView.findViewById(R.id.imgTeamPos3);
            imgPos4       = (ImageView) itemView.findViewById(R.id.imgTeamPos4);
        }

    }
}
