#!/usr/bin/env python
# coding: utf-8

# <nav class="navbar navbar-default">
#   <div class="container-fluid">
#     <div class="navbar-header">
#       <a class="navbar-brand" href="_Oving5.ipynb">Øving 5</a>
#     </div>
#     <ul class="nav navbar-nav">
#       <li ><a href="Generelt%20om%20lister.ipynb">Generelt om lister</a></li>
#     <li ><a href="Lett%20og%20blandet.ipynb">Lett og blandet</a></li>
#     <li class="active"><a href="Kodeforstaelse.ipynb">Kodeforståelse</a></li>
#     <li><a href="Vektorer.ipynb">Vektorer</a></li>
#     <li ><a href="Lister%20og%20lokker.ipynb">Lister og løkker</a></li>
#     <li ><a href="Teoridelen%20paa%20eksamen.ipynb">Teoridelen på eksamen</a></li>
#     <li><a href="Gangetabell%20og%20lister.ipynb">Gangetabell og lister</a></li>
#     <li ><a href="Lotto.ipynb">Lotto</a></li>
#     <li ><a href="Tannfeen.ipynb">Tannfeen</a></li>
#         <li><a href="Chattebot.ipynb">Chattebot</a></li>
#     <li ><a href="Matriseaddisjon.ipynb">Matriseaddisjon</a></li>
#     </ul>
#   </div>
# </nav>
# 
# # Kodeforståelse
# 
# **Læringsmål:**
# 
# * Kodeforståelse
# * Innebygde funksjoner
# * lister
# 
# **Starting Out with Python:**
# 
# * Kap. 7: Lists and Tuples

# **a)** Hva returneres i koden under når A= [1,2,3,5,7,9]?
# 
# Forklar med én setning hva funksjonen gjør.

# ```python
# def myst(A):
#     L=len(A)-1
#     for i in range(len(A)//2):
#         t=A[i]
#         A[i] = A[L-i]
#         A[L-i]=t
#     return A
# ```
# 
# Dobbeltklikk på teksten under og skriv svaret ditt i boksen som kommer opp.

# Svar: Funksjonen bytter mellom første og siste element, deretter andre og nest siste osv. til vi ender på midten av lista 

# **b)** Forklar med én setning hva funksjonen myst3([1,2,3,4,5,6,7,8,9,10]) med kode som vist under gjør.

# ```python
# import random
# def myst3(a):
#     b =[0]*len(a)
#     for c in range(len(a)):
#         d = random.randint(0,len(a)-1)
#         b[c] = a[d]
#         del a[d]    #del fjerner et bestemt element i listen, her fjerner det a[d].
#     return b
# ```
# Dobbeltklikk på teksten under og skriv svaret ditt i boksen som kommer opp.

# Svar: Denne funksjonen fjerner tilfeldige elementer fra listen i argumentet og legger de i rekkefølgen de ble fjernet i listen som returneres

# **c)** Hva kommer koden til å printe?

# ```python
# liste = [4, 9, 6, 3, 8, 7, 5]
# print(liste[-2:6])
# ```
# 
# Dobbeltklikk på teksten under og skriv svaret ditt i boksen som kommer opp.

# Svar: Denne syntaksen gjør at vi skriver ut en liste med element som er nest sist og de neste frem til element med indeks 6. Siden det nest siste elementet har indeks 5 så skriver vi bare ut en liste med elementet på indeks 5 som er 7 dvs. [7]

# **d)** Endre følgende kode slik at den fungerer, og kommenter hva som var feil.

# In[6]:


navn = ['Carina', 'erik', 'Magnus', 'Miriam']
navn[1] = 'Erik'
print(navn)


# Dobbeltklikk på teksten under og skriv svaret ditt i boksen som kommer opp.

# Svar: Tupler har ikke indeksering så jeg gjorde tuppelen om til en liste

# **e)** Hva printes i koden under? Det holder ikke å kopiere koden og kjøre den, du må forklare hva som skjer underveis.

# ```python
# liste1 = [1,3,2,5,4,6]
# liste1.sort()
# liste2 = [7, 8, 9]
# liste3 = liste1+liste2
# liste3.insert(9, 10)
# liste3.remove(1)
# liste3.reverse()
# print(liste3)
# ```
# 
# Dobbeltklikk på teksten under og skriv svaret ditt i boksen som kommer opp.

# Svar: først så sorterer vi listen i stigende rekkefølge, deretter konkatinerer vi den sorterte listen med liste2 slik at liste2-elementene havner først, deretter putter vi tallet 10 på indeks 9 i den konkatinerte listen (liste3), så fjerner vi elementet med verdien 1 fra liste3, så reverserer vi rekkefølgen på elementene i listen og deretter printer ut listen, vil vil altså printe ut listen [10, 9, 8, 7, 6, 5, 4, 3, 2]

# ### Noen innebygde funksjoner

# insert(indexNummer, element) legger til element på indeksen indexNummer i en liste.
# 
# Eksempel:

# In[ ]:


liste = [1,2,3,4,'hei', 5]
liste.insert(3, 'pannekake') #liste = [1, 2, 3, 'pannekake', 4, 'hei', 5]


# sort() sorterer elementene i en liste etter størrelse, med den minste verdien lengst til venstre.

# In[ ]:


liste = [2,3,1,4,6]
liste.sort()   #liste = [1,2,3,4,6]


# remove(element) fjerner element fra listen.

# In[ ]:


liste = [1,2,3,5]
liste.remove(3)  # liste = [1,2,5]


# reverse() reverserer listen, dvs. at listen blir speilet.

# In[ ]:


liste = [1,2,3,5,7]
liste.reverse()    #liste = [7,5,3,2,1]
