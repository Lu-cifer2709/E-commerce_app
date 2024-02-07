package com.example.nexbuy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.nexbuy.databinding.ActivityAdminBinding;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class AdminActivity extends AppCompatActivity {
    ActivityAdminBinding binding;
    private String id, title, desc, price;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnAddprod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title = binding.prodTitle.getText().toString();
                desc = binding.prodDesc.getText().toString();
                price = binding.prodPrice.getText().toString();
                addProduct();
            }
        });

        binding.prodImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);
            }
        });

        binding.btnUploadpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadImg();
            }
        });

        binding.btnadminlogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(AdminActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }

    private void uploadImg() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference("products/" + id +".png");

        storageReference.putFile(uri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                        storageReference.getDownloadUrl()
                                .addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        FirebaseFirestore.getInstance()
                                                .collection("products")
                                                .document(id)
                                                .update("img", uri.toString());
                                        Toast.makeText(AdminActivity.this, "Done", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });
    }

    private void addProduct() {
        id = UUID.randomUUID().toString();
        ProductModel productModel = new ProductModel(id, title, desc, null, price, true);
        FirebaseFirestore.getInstance()
                .collection("products")
                .document(id)
                .set(productModel);
        Toast.makeText(this, "Product Added", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            uri = data.getData();
            binding.prodImg.setImageURI(uri);
        }
    }
}