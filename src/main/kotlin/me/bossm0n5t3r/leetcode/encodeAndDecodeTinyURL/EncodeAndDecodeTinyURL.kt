package me.bossm0n5t3r.leetcode.encodeAndDecodeTinyURL

import kotlin.random.Random

class EncodeAndDecodeTinyURL {
    class Codec {
        private val baseHost = "http://tinyurl.com/"
        private val shortUrlToLongUrl = mutableMapOf<String, String>()
        private val longUrlToShortUrl = mutableMapOf<String, String>()
        private val charPool = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        private val stringLength = 6

        // Encodes a URL to a shortened URL.
        fun encode(longUrl: String): String {
            if (longUrlToShortUrl.containsKey(longUrl)) return baseHost + longUrlToShortUrl[longUrl]
            var key = ""
            do {
                key =
                    (1..stringLength)
                        .map { Random.nextInt(0, charPool.size) }
                        .map(charPool::get)
                        .joinToString("")
            } while (shortUrlToLongUrl.containsKey(key))
            shortUrlToLongUrl[key] = longUrl
            longUrlToShortUrl[longUrl] = key
            return baseHost + key
        }

        // Decodes a shortened URL to its original URL.
        fun decode(shortUrl: String): String {
            return shortUrlToLongUrl[shortUrl.replace(baseHost, "")]!!
        }

        fun cleanUp() {
            shortUrlToLongUrl.clear()
            longUrlToShortUrl.clear()
        }

        fun numberOfKey() = shortUrlToLongUrl.keys.size
    }
}
