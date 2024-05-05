import requests
from selenium import webdriver
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.common.by import By
from bs4 import BeautifulSoup as Soup
from selenium.webdriver.edge.service import Service
import time
import pandas as pd
service = Service(executable_path="C:\ebirdCrawler\chromedriver.exe")
driver = webdriver.Chrome()


url = 'https://media.ebird.org/catalog?taxonCode=crseag1&mediaType=photo&sort=rating_rank_desc&regionCode=TW'
driver.get(url)


soup = Soup(driver.page_source,'lxml')


data = []
href_elements = soup.find_all(class_="ResultsGallery-link")
for element in href_elements:
    # href_value = element["href"]
    # print(f"{href_value}")
    href_value = element.get("href")
    data.append({"href": href_value})
    time.sleep(3)

img_elements = soup.find_all("img")

# 提取 alt 和 src 屬性的值
for element in img_elements:
    alt_value = element.get("alt")
    # print(f" {alt_value}")
    data.append({"alt": alt_value})
    time.sleep(3)
    src_value = element.get("src")
    # print(f" {src_value}")
    data.append({"src": src_value})
    time.sleep(3)
    # 創建 DataFrame


    # srcset_value = element.get("srcset")
    # if srcset_value:
    #     resolutions = srcset_value.split(",")
    #     for resolution in resolutions:
    #         if "640w" in resolution:
    #             src_url = resolution.split()[0]
    #             print(f"{src_url}")
    #             time.sleep(3)

                              


#write in the first time
df = pd.DataFrame(data)
# 將 DataFrame 寫入 CSV 檔案
df.to_csv("image_attributes2.csv", index=False)
df = pd.DataFrame(data)
driver.quit()

