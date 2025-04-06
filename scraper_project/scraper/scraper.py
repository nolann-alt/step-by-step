import requests
from bs4 import BeautifulSoup

# lien tuto : https://brightdata.fr/blog/savoir-faire/web-scraping-with-python#:~:text=La%20premi%C3%A8re%20%C3%A9tape%20pour%20construire,n%C3%A9cessaires%20sur%20le%20site%20web.

# Agent utilisateur pour simuler un navigateur
header = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/5374"
}

# URL de la page à scraper
page = requests.get("https://www.instant-gaming.com/fr/")

# Vérification du statut de la requête
soup = BeautifulSoup(page.text, "html.parser")

# permet de recuperer tout les elements "li" dans la navbar du site
soup.find(class_='navbar').find_all('li')
soup.select('.navbar > li')

# extraction des jeux tendances
listing_items = []
listing_items_elements = soup.find_all('div', class_='listing-item')

for listing_items in listing_items:
