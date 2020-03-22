* call intent

val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "1122334455"))

* sms intent

val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "1122334455"))

* url intent

val openURL = Intent(Intent.ACTION_VIEW)

openURL.data = Uri.parse("https://www.google.com/")

* new activity intent

startActivity(Intent(this,AnotherActivity::class.java))

* pass to data activity intent

val intent = Intent(this,AnotherActivity::class.java)

intent.putExtra("text",editText.text.toString())

startActivity(intent)
