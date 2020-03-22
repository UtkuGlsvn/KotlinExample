* call intent

val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "callphone number"))

* sms intent

val intent = Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + "message phone number"))

* url intent

val openURL = Intent(Intent.ACTION_VIEW)

openURL.data = Uri.parse("go to website")

* new activity intent

startActivity(Intent(this,AnotherActivity::class.java))

* pass to data activity intent

val intent = Intent(this,AnotherActivity::class.java)

intent.putExtra("value",editText.text.toString())

startActivity(intent)
