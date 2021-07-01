# 不動産システム開発

**「飞毛骡」**
SpringBootフレームワークを用いた「飞毛骡」という不動産を新規作成しました。当サイトは部屋賃貸、ユーザ管理などの機能が付きます。 開発の期間は約５ヶ月でした。

機能一覧は以下となります



| 区分   | 機能名              |                  |            |                                                     機能概要 |
| :----- | :------------------ | :--------------- | :--------- | -----------------------------------------------------------: |
| 共通   | 登録                |                  |            |                   新規アカウント作成＆ログイン画面に遷移する |
|        | ログイン            |                  |            |                         ログインする＆ホームページに遷移する |
|        | パスワード暗号化    |                  |            |                                       パスワードを暗号化する |
|        | ログアウト          |                  |            |                     ログアウトすると、ホームページへ遷移する |
|        | インターセプター    |                  |            | 未ログインまたは未登録の場合、マイページアクセス制御、気に入り制御 |
|        | 会員新規登録        |                  |            |                                   お客様の情報を新規登録する |
| 管理員 | ユーザ管理/企業管理 |                  |            |                                    ユーザ/企業の変更ができる |
|        | 部屋管理            |                  |            |                                 部屋情報をチェック、削除する |
|        | パスワード 変更     |                  |            |                                     パスワードの変更ができる |
|        | 不動産企業情報      |                  |            |                               不動産企業情報を編集、保存する |
| 企業   | 建物情報            | 新規             |            |                                                   建物を新規 |
|        |                     | 編集             |            |                                                   建物を編集 |
|        |                     | 複数の写真を追加 |            |                                             建物を写真を追加 |
|        |                     | 削除             |            |                                                   建物を削除 |
|        |                     | 部屋情報         | 新規       |                                                   部屋を新規 |
|        |                     |                  | 編集       |                                                   部屋を編集 |
|        |                     |                  | 写真を追加 |                                             部屋を写真を追加 |
|        |                     |                  | 削除       |                                                   部屋を削除 |
|        | パスワード 変更     |                  |            |                                     パスワードの変更ができる |
|        | staff               | 新規             |            |                                               スタッフを新規 |
|        |                     | 編集             |            |                                           スタッフの内容編集 |
|        |                     | 削除             |            |                                               スタッフを削除 |
| ユーザ | 情報管理            | 個人情報を編集   |            |                                     基本情報を編集、保存する |
|        |                     | アイコンを変更   |            |                                     アイコンを編集、保存する |
|        |                     | パスワード 変更  |            |                                     パスワードの変更ができる |
|        | お気に入り          |                  |            |                   物件をお気に入り、お気に入り一覧表示できる |


# 1．開発環境

| 1-1　IDE：Eclipse                                    |
| :--------------------------------------------------- |
| 1-2　OS：Windows10                                   |
| 1-3　JDK：Java8                                      |
| 1-4　フレームワーク：SpringBoot2.4.3                 |
| 1-5　データベース：PostgreSQL                        |
| 1-6　ソース管理：GitHub                              |
| 1-7　テスト：Junit                                   |
| 1-8　テンプレートエンジン：Thymeleaf                 |
| 1-9　画面：Html、JavaScript、jQuery、Ajax、Bootstrap |

# 2．構成

画面遷移図

![image-20210629113406665](https://github.com/mfl1989/fudousan/blob/main/imgs/32b747c7efc514eae699d8ba989867d.png)

#### 2.1 er図

![_20210629113458](https://github.com/mfl1989/fudousan/blob/main/imgs/23d5fa4ff96eca50ef20600016f46c4.png)



# 3. 画面



#### 3.1メイン画面

![image-20210629113925886](https://github.com/mfl1989/fudousan/blob/main/imgs/560b4c9545f4ed093140790842473ad.png)

#### 3.2登録

![image-20210629114025826](https://github.com/mfl1989/fudousan/blob/main/imgs/e4bade193c7904f2d1a51e3c78a1b76.png)
#### 3.21会社新規
![1327dd7eb96c17f5f7fc011320d4857](https://github.com/mfl1989/fudousan/blob/main/imgs/1327dd7eb96c17f5f7fc011320d4857.png)
#### 3.22新規
![5266cc69c55cec695405c0b5c6b3d5b](https://github.com/mfl1989/fudousan/blob/main/imgs/5266cc69c55cec695405c0b5c6b3d5b.png)
#### 3.3　ログインしたの画面

![image-20210629114214144](https://github.com/mfl1989/fudousan/blob/main/imgs/image-20210629114214144.png)

#### 3.4個人センター

#### ![image-20210629114341658](https://github.com/mfl1989/fudousan/blob/main/imgs/ca6cb587cbfcc8430b1a5771d90a706.png)

![image-20210629114715937](https://github.com/mfl1989/fudousan/blob/main/imgs/2e9482d66d6071bea8da9fee52e47ce.png)

#### 3-5　パスワード・変更

![image-20210629114901942](https://github.com/mfl1989/fudousan/blob/main/imgs/0116f21d9dd4e672a811d906736f7ae.png)

#### 3-6　お気に入り一覧

![image-20210629115425136](https://github.com/mfl1989/fudousan/blob/main/imgs/75ef4a61a3f19ec37a61619f587efce.png)

#### 3-7　物件アップロード

![image-20210629115211797](https://github.com/mfl1989/fudousan/blob/main/imgs/92c7bf9c2fcd7e6cc8a35896204e204.png)

#### 3-7　店舗管理物件一覧

![image-20210629115704012](https://github.com/mfl1989/fudousan/blob/main/imgs/98d7250cce6afd97c672dbcb6a08f5c.png)

#### 3.8 staff一覧

![image-20210629115744780](https://github.com/mfl1989/fudousan/blob/main/imgs/cb5b8ab17f623d19957c26a8c3adbf5.png)

#### 3.9 物件編集



![image-20210629115849013](https://github.com/mfl1989/fudousan/blob/main/imgs/f12895394fdcd760680c0864a20ea4f.png)

#### 3.10  admin

![image-20210629115949177](https://github.com/mfl1989/fudousan/blob/main/imgs/6b1f165f94736f06b359abab7332190.png)

#### 3.11  ユーザー一覧

![image-20210629120038557](https://github.com/mfl1989/fudousan/blob/main/imgs/703df95dc9d875005276635cc8b12df.png)

#### 3.12 物件一覧



![image-20210629120320824](https://github.com/mfl1989/fudousan/blob/main/imgs/5a1d958f1cf7265fd5b4fcc4399fd57.png)
![2703774586e038d03dec6a613e33b6e](https://github.com/mfl1989/fudousan/blob/main/imgs/2703774586e038d03dec6a613e33b6e.png)

# ４．後ろ書き

この作品は独学中の作品で，自分で要件定義からテストまでを設計しましたので、不合理的な部分がありますが、技術アップために作成された、　これから開発に頑張りたいと思います。

また、記述ミスや間違いがあれば、ご遠慮なくご指摘ください。
