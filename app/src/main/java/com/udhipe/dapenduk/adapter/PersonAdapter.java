package com.udhipe.dapenduk.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.udhipe.dapenduk.R;
import com.udhipe.dapenduk.model.Person;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> implements PersonAdapterContract.View {

    private OnItemClickCallback onItemClickCallback;

    private PersonAdapterPresenter mPresenter;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PersonAdapter(PersonAdapterPresenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_person, parent, false);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final PersonViewHolder holder, final int position) {
        mPresenter.getPerson(position, holder);

        holder.mButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onEditClicked(position);
            }
        });

        holder.mButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onDeleteClicked(position);
            }
        });

        holder.mItemPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPresenter.countListPersonSize();
    }

    @Override
    public void refreshDataView() {
        notifyDataSetChanged();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements PersonAdapterContract.View.Holder {

        private RelativeLayout mItemPerson;
        private TextView mTextView;
        private MaterialButton mButtonEdit;
        private MaterialButton mButtonDelete;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);

            mItemPerson = itemView.findViewById(R.id.item_person);
            mTextView = itemView.findViewById(R.id.tv_name);
            mButtonEdit = itemView.findViewById(R.id.btn_edit);
            mButtonDelete = itemView.findViewById(R.id.btn_delete);

        }

        @Override
        public void setTitle(String name) {
            mTextView.setText(name);
        }

        @Override
        public void setAddress(String address) {

        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(int position);

        void onDeleteClicked(int position);

        void onEditClicked(int position);
    }
}
