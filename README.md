## simpleClientWPS
A client and web-proxy-server with raw HTTP

### About
This implementation lets client (C) and server (WPS) communicate by UDP, returning header info of TCP proxies of raw HTTP requests.

An example run of hosthame [vg.no](www.vg.no) returns the printout:

```
www.vg.no
Mottatt: HTTP/1.1 302 Found
Date: Fri, 23 Mar 2020 22:48:09 GMT
Server: Apache/2.4.6 (CentOS)
X-VG-WebServer: redirect-01
Location: http://www.vg.no/
Content-Type: text/html; charset=iso-8859-1
X-VG-WebCache: u89-varnish-01
X-Cache: MISS
Vary: User-Agent
X-Age: 0
Age: 0
Connection: keep-alive
```

An example printout of an 404 bad request:

```
Mottatt: HTTP/1.1 400 Bad Request
Date: Fri, 23 Mar 2020 22:16:00 GMT
Server: mw1275.eqiad.wmnet
Content-Type: text/html; charset=iso-8859-1
X-Varnish: 674434838, 520532266, 503848835
Via: 1.1 varnish (Varnish/5.1), 1.1 varnish (Varnish/5.1), 1.1 varnish (Varnish/5.1)
Age: 0
X-Cache: cp1054 pass, cp3043 pass, cp3042 pass
X-Cache-Status: pass
Set-Cookie: WMF-Last-Access=23-Mar-2020;Path=/;HttpOnly;secure;Expires=Tue, 24 Apr 2020 12:00:00 GMT
Set-Cookie: WMF-Last-Access-Global=23-Mar-2018;Path=/;Domain=.;HttpOnly;secure;Expires=Tue, 24 Apr
2020 12:00:00 GMT
X-Analytics: nocookies=1
X-Client-IP: 217.17.218.148
Set-Cookie: GeoIP=NO:11:Sokndal:58.33:6.30:v4; Path=/; secure; Domain=.
Connection: keep-alive
```
