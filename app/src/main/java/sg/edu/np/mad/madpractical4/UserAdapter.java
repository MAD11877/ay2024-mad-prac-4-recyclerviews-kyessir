package sg.edu.np.mad.madpractical4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {
    private List<User> userList;

    public UserAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.nameView.setText(user.name);
        holder.descriptionView.setText(user.description);

        // Set a placeholder image for the profile. If you have actual images, you can load them here.
        holder.smallImgView.setImageResource(R.drawable.ic_launcher_foreground);
        holder.bigImgView.setImageResource(R.drawable.ic_launcher_foreground);
        // Follow button logic can be added here if needed
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView nameView, descriptionView;
        ImageView smallImgView, bigImgView;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            descriptionView = itemView.findViewById(R.id.description);
            smallImgView = itemView.findViewById(R.id.smallImg);
            bigImgView = itemView.findViewById(R.id.bigImg);
        }
    }
}
