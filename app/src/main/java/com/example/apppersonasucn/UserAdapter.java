package com.example.apppersonasucn;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apppersonasucn.entity.User;
import com.example.apppersonasucn.util.UserList;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> userList;
    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView firstname;
            private TextView lastname;
            private TextView age;
            private TextView email;
            //
            private Button btnDelete;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                firstname = (TextView) view.findViewById(R.id.user_item_firstNameId);
                age = (TextView) view.findViewById(R.id.user_item_ageId);
                email = (TextView) view.findViewById(R.id.user_item_emailId);
                //
                btnDelete = (Button) view.findViewById(R.id.user_item_btn_deleteId);
            }

        }

        // Create new views (invoked by the layout manager)
        @Override
        public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            // Create a new view, which defines the UI of the list item
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.user_item_layout, viewGroup, false);

            return new ViewHolder(view);
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            viewHolder.firstname.setText(userList.get(position).getFirstName());
            viewHolder.age.setText(String.valueOf(userList.get(position).getAge()));
            viewHolder.email.setText(userList.get(position).getEmail());

            // Obtener los datos del usuario en la posición dada
            User user = userList.get(position);

            // Configurar el clic del botón de eliminar
            viewHolder.btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Acciones a realizar cuando se hace clic en el botón de eliminar
                    userList.remove(user);
                    notifyDataSetChanged();

                    // Recrea la actividad para recargar la pantalla
                    ((Activity) v.getContext()).recreate();
                }
            });
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return userList.size();
        }
    }

