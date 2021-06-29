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

![image-20210629113406665](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629113406665.png)

#### ER図

![_20210629113458](C:\Users\mfl\Desktop\_20210629113458.png)

# 3. 画面



#### 3.1メイン画面

![image-20210629113925886](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629113925886.png)

#### 3.2登録

![image-20210629114025826](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629114025826.png)

#### 3.3　ログインしたの画面

![image-20210629114214144](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629114214144.png)

#### 3.4個人センター

#### 

![image-20210629114341658](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629114341658.png)

![image-20210629114715937](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629114715937.png)

#### 3-5　パスワード・変更

![image-20210629114901942](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629114901942.png)

#### 3-6　お気に入り一覧

![image-20210629115425136](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115425136.png)

#### 3-7　物件アップロード

![image-20210629115601724](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115601724.png)

#### 3-7　物件一覧

![image-20210629115704012](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115704012.png)

#### 3.8 staff一覧

![image-20210629115744780](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115744780.png)

#### 3.9 物件編集



![image-20210629115849013](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115849013.png)

#### 3.10  admin

![image-20210629115949177](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629115949177.png)

#### 3.11  ユーザー一覧

![image-20210629120038557](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629120038557.png)

#### 3.12 物件一覧



![image-20210629120320824](C:\Users\mfl\AppData\Roaming\Typora\typora-user-images\image-20210629120320824.png)

# ４．後ろ書き

この作品は独学中の作品で，自分で要件定義からテストまでを設計しましたので、不合理的な部分がありますが、技術アップために作成された、　これから開発に頑張りたいと思います。

また、記述ミスや間違いがあれば、ご遠慮なくご指摘ください。