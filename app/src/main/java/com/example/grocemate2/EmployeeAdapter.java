package com.example.grocemate2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    private final Context context;
    private final List<String> employeeNames;

    public EmployeeAdapter(Context context, List<String> employeeNames) {
        this.context = context;
        this.employeeNames = employeeNames;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        holder.nameTextView.setText(employeeNames.get(position));

        holder.itemView.setOnClickListener(v -> {
            String message = employeeNames.get(position) + " clicked";
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return employeeNames.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }
    }
}
