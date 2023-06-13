package me.bossm0n5t3r.leetcode.encodeAndDecodeTinyURL

import kotlin.random.Random

class EncodeAndDecodeTinyURL {
    class Codec {
        private val BASE_HOST = "http://tinyurl.com/"
        private val shortUrlToLongUrl = mutableMapOf<String, String>()
        private val longUrlToShortUrl = mutableMapOf<String, String>()
        private val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        private val STRING_LENGTH = 6

        // Encodes a URL to a shortened URL.
        fun encode(longUrl: String): String {
            if (longUrlToShortUrl.containsKey(longUrl)) return BASE_HOST + longUrlToShortUrl[longUrl]
            var key = ""
            do {
                key = (1..STRING_LENGTH)
                    .map { Random.nextInt(0, charPool.size) }
                    .map(charPool::get)
                    .joinToString("")
            } while (shortUrlToLongUrl.containsKey(key))
            shortUrlToLongUrl[key] = longUrl
            longUrlToShortUrl[longUrl] = key
            return BASE_HOST + key
        }

        // Decodes a shortened URL to its original URL.
        fun decode(shortUrl: String): String {
            return shortUrlToLongUrl[shortUrl.replace(BASE_HOST, "")]!!
        }

        fun cleanUp() {
            shortUrlToLongUrl.clear()
            longUrlToShortUrl.clear()
        }

        fun numberOfKey() = shortUrlToLongUrl.keys.size
    }
}
