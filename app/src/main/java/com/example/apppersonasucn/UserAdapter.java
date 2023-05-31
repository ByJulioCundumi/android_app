package com.example.apppersonasucn;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
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
            private Button btnDetails;
            private Button btnEdit;
            private Button btnHobbies;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                firstname = (TextView) view.findViewById(R.id.user_item_firstNameId);
                age = (TextView) view.findViewById(R.id.user_item_ageId);
                email = (TextView) view.findViewById(R.id.user_item_emailId);
                //
                btnDelete = (Button) view.findViewById(R.id.user_item_btn_deleteId);
                btnDetails = (Button) view.findViewById(R.id.user_item_btn_detailsId);
                btnEdit = (Button) view.findViewById(R.id.user_item_btn_editId);
                btnHobbies = (Button) view.findViewById(R.id.user_item_btn_hobbies);
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

            // Configurar el clic del botón de consultar
            viewHolder.btnDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Acciones a realizar cuando se hace clic en el botón de eliminar
                    Intent intent = new Intent(v.getContext(), UserDetails.class);

                    // Agregar los datos del objeto User como extras en el Intent
                    intent.putExtra("userData", user);

                    // Iniciar el nuevo Activity
                    v.getContext().startActivity(intent);
                }
            });

            viewHolder.btnEdit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Acciones a realizar cuando se hace clic en el botón de editar
                    Intent intent = new Intent(v.getContext(), UpdateUserActivity.class);

                    // Agregar los datos del objeto User como extras en el Intent
                    intent.putExtra("userData", user);
                    intent.putExtra("position", UserList.getUserList().indexOf(user));

                    // Iniciar el nuevo Activity
                    v.getContext().startActivity(intent);
                }
            });

            viewHolder.btnHobbies.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Acciones a realizar cuando se hace clic en el botón de hobbies
                    Dialog hobbiesPopUp = new Dialog(v.getContext());
                    hobbiesPopUp.setContentView(R.layout.activity_hobbies);

                    // Agregar los datos del objeto User como extras en el Intent
                    Intent intent = new Intent(v.getContext(), hobbiesActivity.class);
                    intent.putExtra("userData", user);
                    intent.putExtra("position", UserList.getUserList().indexOf(user));

                    // Iniciar el nuevo Activity
                    v.getContext().startActivity(intent);
                }
            });
        }

        // Return the size of dataset
        @Override
        public int getItemCount() {
            return userList.size();
        }
    }


