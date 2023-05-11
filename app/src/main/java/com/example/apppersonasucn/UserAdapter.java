package com.example.apppersonasucn;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.apppersonasucn.entity.User;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

        private List<User> userList;

        /**
         * Provide a reference to the type of views that you are using
         * (custom ViewHolder).
         */
        public static class ViewHolder extends RecyclerView.ViewHolder {
            private TextView firstname;
            private TextView lastname;
            private TextView age;
            private TextView email;

            public ViewHolder(View view) {
                super(view);
                // Define click listener for the ViewHolder's View

                firstname = (TextView) view.findViewById(R.id.user_item_firstNameId);
                age = (TextView) view.findViewById(R.id.user_item_ageId);
                email = (TextView) view.findViewById(R.id.user_item_emailId);
            }

        }


        public UserAdapter(List<User> userList) {
            this.userList = userList;
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
        public void onBindViewHolder(ViewHolder viewHolder, int position) {

            // Get element from your dataset at this position and replace the
            // contents of the view with that element
            viewHolder.firstname.setText(userList.get(position).getFirstName());
            viewHolder.age.setText(String.valueOf(userList.get(position).getAge()));
            viewHolder.email.setText(userList.get(position).getEmail());
        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return userList.size();
        }
    }


