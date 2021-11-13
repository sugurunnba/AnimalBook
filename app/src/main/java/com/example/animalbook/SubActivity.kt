package com.example.animalbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animalbook.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
//    タイトルフラグメントの初期化
    private lateinit var title: TitleFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        activity_sub.xmlの中にあるlionButtonがクリックされた時に起動するメソッド
        binding.lionButton.setOnClickListener {
//            biginTransaction() = フラグメントマネージャーのインスタンスを取得
            supportFragmentManager.beginTransaction().apply{
//                LionFragmentをcontainerに配置する, replaceはフラグメントの入れ替えを行う
                replace(R.id.container, LionFragment())
//                バックスタックに保存, これを行うことで戻るボタンを押した時に１つ前の状態に戻すことができる
                addToBackStack(null)
//                フラグメントの処理を確定する
                commit()
            }
        }
        binding.hippoButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.container, HippoFragment())
                addToBackStack(null)
                commit()
            }
        }
        binding.giraffeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.container, GiraffeFragment())
                addToBackStack(null)
                commit()
            }
        }

//        初期化したタイトルフラグメントを使用する
        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.titleFrame, title)
            commit()
        }
    }

//    タイトルフラグメントに名前を入れる
    override fun onResume(){
        super.onResume()
        title.setTitle("サブ画面")
    }
}